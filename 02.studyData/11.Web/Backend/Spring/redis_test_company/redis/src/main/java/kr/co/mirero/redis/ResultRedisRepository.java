package kr.co.mirero.redis;

import org.springframework.data.repository.CrudRepository;

public interface ResultRedisRepository extends CrudRepository<ResultHistory, String> {
}
