package kr.co.mirero.redis;

 import lombok.Getter;
 import lombok.RequiredArgsConstructor;
 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
 import org.springframework.data.redis.connection.RedisConfiguration;
 import org.springframework.data.redis.connection.RedisConnectionFactory;
 import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
 import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
 import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
 import org.springframework.data.redis.core.RedisTemplate;
 import org.springframework.data.redis.serializer.StringRedisSerializer;



@Getter
@Configuration
@RequiredArgsConstructor
public class RedisConfig {

    @Value("${spring.cache.redis.host}")
    private String host;

    @Value("${spring.cache.redis.port}")
    private int port;

    /**
     * 내장 혹은 외부의 Redis를 연결
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory(host, port);
    }

    /**
     * RedisConnection에서 넘겨준 byte 값 객체 직렬화
     */
    @Bean
    public RedisTemplate<?,?> redisTemplate(){
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
