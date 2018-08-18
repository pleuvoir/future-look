package io.github.pleuvoir.redis;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserCache, String> {
	
}
