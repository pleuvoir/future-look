package com.pleuvoir.task;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.pleuvoir.common.AbstractLog;

@Component
public class Scheduler extends AbstractLog{
	
    @Scheduled(cron = "*/1 * * * * *")
    public void excute() {
    	logger.debug("定时任务测试:{}", new Date());
    }
   
}
