package com.wangby.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author: wangby
 * @create: 2020/5/3
 */
@Configuration
public class MyTemplete {

    @Bean
    public StringRedisTemplate myRedisTemplate(RedisConnectionFactory fc) {
        StringRedisTemplate srt = new StringRedisTemplate(fc);
        srt.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        return srt;
    }
}
