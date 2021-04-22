package com.hl.springbootdemo1.chapter23.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
}
