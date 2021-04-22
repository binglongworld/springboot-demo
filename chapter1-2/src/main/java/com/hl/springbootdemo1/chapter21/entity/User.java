package com.hl.springbootdemo1.chapter21.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "用户实体类")
@Data
public class User {
    @Max(10000)
    @ApiModelProperty(value = "用户id")
    private Long id;

    @Size(min = 2, max = 10)
    @NotNull(message = "用户名称不能为空")
    @ApiModelProperty(value = "用户名称")
    private String name;

    @NotNull
    @Min(1)
    @ApiModelProperty(value = "用户年龄,最小1")
    private Integer age;
}
