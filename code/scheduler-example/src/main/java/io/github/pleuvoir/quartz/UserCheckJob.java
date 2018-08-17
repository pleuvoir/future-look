package io.github.pleuvoir.quartz;

import java.util.Optional;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;
import io.github.pleuvoir.redis.UserCache;
import io.github.pleuvoir.redis.UserRepository;

/**
 * 专场拍品结束时间检查，每一秒检查一次<br/>
 * 到达结束时间时，锁定拍品并发送《专场拍品结束》MQ，并发送《创建订单》MQ
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class UserCheckJob implements Job {

	private static Logger logger = LoggerFactory.getLogger(UserCheckJob.class);

	@Autowired
	private UserRepository userRepository;


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		String id = context.getJobDetail().getJobDataMap().getString("id");

		//检查用户缓存，若不存在，进行逻辑处理，这个缓存可以在其他地方初始化，这里进行使用进行逻辑判断
		Optional<UserCache> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent()){
			RedisHash redisHash = UserCache.class.getAnnotation(RedisHash.class);
			logger.info("【用户检查】缓存中未能查询到用户，表示用户尚未激活，RedisHash:{}， id：{}",
					redisHash == null ? "null" : redisHash.value(), id);
			return;
		}

		UserCache userCache = userOptional.get();

		if (logger.isInfoEnabled()) {
			logger.info("【用户检查】缓存中查询到用户，表示用户已激活，id：{}", userCache.getId());
		}
		
			// 逻辑
			try {
				removeTrigger(context, id);
			} catch (SchedulerException e) {
				throw new JobExecutionException("业务异常", e);
			}
		}


	private void removeTrigger(JobExecutionContext context, String id) throws SchedulerException {
		TriggerKey triggerKey = new TriggerKey(id, QuartzConst.TriggerKeyGroup.USER_CHECK);
		try {
			context.getScheduler().unscheduleJob(triggerKey);
		} catch (SchedulerException e) {
			logger.error("【用户激活检查】移除当前定时任务失败，TriggerKey: {}", triggerKey.toString(), e);
			throw e;
		}
	}

}
