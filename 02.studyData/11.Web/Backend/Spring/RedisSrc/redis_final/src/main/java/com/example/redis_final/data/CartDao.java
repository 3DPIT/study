package com.example.redis_final.data;

import com.example.redis_final.util.KeyGen;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
@RequiredArgsConstructor
public class CartDao {

    private final RedisTemplate<String, Object> redisTemplate;

    public void addItem(ItemDto itemDto, Long memberId){
        String key = KeyGen.cartKeyGenerate(memberId);
        redisTemplate.opsForValue().set(key, itemDto);
        redisTemplate.expire(key, 60, TimeUnit.MINUTES);
    }

    public ItemDto findByMemberId(Long memberId){
        String key = KeyGen.cartKeyGenerate(memberId);
        return (ItemDto) redisTemplate.opsForValue().get(key);
    }
}

