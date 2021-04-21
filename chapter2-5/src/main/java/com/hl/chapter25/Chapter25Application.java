package com.hl.chapter25;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hl"})
@MapperScan("com.hl.chapter25.mapper")
@EnableCaching
public class Chapter25Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter25Application.class, args);
    }


}
