package kr.co.mirero.redis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.LocalDateTime;

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testString(){
        //given
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "stringKey";

        //when
        valueOperations.set(key,"hello");

        //then
        String value = valueOperations.get(key);
        Assertions.assertThat(value).isEqualTo(key);
    }

    @Autowired
    private ResultRedisRepository redisRepository;

    @AfterEach
    void afterAll() {
        redisRepository.deleteAll();
    }

    @Test
    void save() throws Exception {
        // given
        ResultHistory result = ResultHistory.builder()
                .ip("localhost")
                .originalText("안녕하세요.")
                .translatedText("hello")
                .createDateTime(LocalDateTime.now())
                .build();

        // when
        ResultHistory save = redisRepository.save(result);

        // then
        ResultHistory find = redisRepository.findById(save.getId()).get();

        Assertions.assertThat(save.getIp()).isEqualTo(find.getIp());
        Assertions.assertThat(save.getOriginalText()).isEqualTo(find.getOriginalText());
        Assertions.assertThat(save.getTranslatedText()).isEqualTo(find.getTranslatedText());
    }
}
