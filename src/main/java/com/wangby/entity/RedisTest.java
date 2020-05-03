package com.wangby.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: wangby
 * @create: 2020/5/3
 */
@Component
public class RedisTest {

    @Autowired
    @Qualifier("myRedisTemplate")
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void test() {

        Person p = new Person();
        p.setName("wangby");
        p.setAge(22);


        //stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        Jackson2HashMapper jm = new Jackson2HashMapper(objectMapper, false);
        stringRedisTemplate.opsForHash().putAll("wangby01", jm.toHash(p));

        Map wangby01 = stringRedisTemplate.opsForHash().entries("wangby01");

        Person per = objectMapper.convertValue(wangby01, Person.class);
        System.out.println(per);
    }


}
