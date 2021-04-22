package com.hl.chapter34;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hl"})
@MapperScan("com.hl.chapter34.mapper")
@EnableCaching
public class Chapter34Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter34Application.class, args);
    }


}
