package com.hl.springbootdemo1.chapter22.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 教师管理
 */
@Api(tags = {"教师管理", "教学管理"})
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @ApiOperation("获取某个学生的老师清单")
    @GetMapping(value = "/b")
    public String b() {
        return "b";
    }

    @ApiOperation("获取老师清单")
    @GetMapping(value = "/a")
    public String a() {
        return "a";
    }
}
