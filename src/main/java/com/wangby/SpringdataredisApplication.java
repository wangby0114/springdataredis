package com.wangby;

import com.wangby.entity.RedisTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringdataredisApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext cgx = SpringApplication.run(SpringdataredisApplication.class, args);

        RedisTest redT = cgx.getBean(RedisTest.class);
        redT.test();
    }

}
