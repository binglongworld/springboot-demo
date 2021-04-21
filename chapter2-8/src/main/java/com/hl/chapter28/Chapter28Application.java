package com.hl.chapter28;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hl"})
@MapperScan("com.hl.chapter28.mapper")
@EnableCaching
public class Chapter28Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter28Application.class, args);
    }


}
