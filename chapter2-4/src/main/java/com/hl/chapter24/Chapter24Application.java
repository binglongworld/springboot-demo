package com.hl.chapter24;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hl"})
@MapperScan("com.hl.chapter24.mapper")
public class Chapter24Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter24Application.class, args);
    }


}
