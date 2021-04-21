package com.hl.chapter27;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hl"})
@MapperScan("com.hl.chapter27.mapper")
@EnableCaching
public class Chapter27Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter27Application.class, args);
    }


}
