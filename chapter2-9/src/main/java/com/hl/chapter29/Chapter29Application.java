package com.hl.chapter29;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Chapter29Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter29Application.class, args);
    }

}
