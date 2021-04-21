package com.hl.chapter31.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ApiModel(description = "用户信息")
public class User implements Serializable {
    @ApiModelProperty(value = "用户ID")
    private Long id;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
