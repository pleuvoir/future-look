package io.github.pleuvoir.redis;

import java.util.concurrent.TimeUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("user")
public class UserCache {

	@Id
	private String id;
	
	private String name;
	
	@TimeToLive(unit = TimeUnit.HOURS)
	private Long ttl = 24L * 3;			//缓存有效时间（3天）
	
}
