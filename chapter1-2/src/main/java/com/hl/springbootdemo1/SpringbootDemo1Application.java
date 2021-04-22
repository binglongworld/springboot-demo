package com.hl.springbootdemo1;

import com.hl.web.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hl.rest", "com.hl.springbootdemo1"})
public class SpringbootDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo1Application.class, args);
    }

    @Bean
    public UserController userController() {
        return new UserController();
    }

}
