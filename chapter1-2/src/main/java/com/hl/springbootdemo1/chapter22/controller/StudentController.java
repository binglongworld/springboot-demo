package com.hl.springbootdemo1.chapter22.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "学生管理")
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @ApiOperation(value = "获取学生清单", tags = "教学管理")
    @GetMapping(value = "/aa")
    public String aa() {
        return "aa";
    }

    @ApiOperation("获取某个老师的学生清单")
    @GetMapping(value = "/bb")
    public String bb() {
        return "bb";
    }
}
