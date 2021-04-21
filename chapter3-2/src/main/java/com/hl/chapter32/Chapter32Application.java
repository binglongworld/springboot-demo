package com.hl.chapter32;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hl"})
@MapperScan("com.hl.chapter32.mapper")
@EnableCaching
public class Chapter32Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter32Application.class, args);
    }


}
