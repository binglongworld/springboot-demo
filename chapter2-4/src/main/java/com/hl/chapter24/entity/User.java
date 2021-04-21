package com.hl.chapter24.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;

@Data
@NoArgsConstructor
@ApiModel(description = "用户信息")
public class User {
    @ApiModelProperty(value = "用户ID")
    private Long id;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    @Max(value = 50, message = "年龄最大不能超过50")
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
