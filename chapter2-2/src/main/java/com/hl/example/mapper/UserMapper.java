package com.hl.example.mapper;

import com.hl.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface UserMapper {
    int deleteUser();

    User findByName(@Param("name") String name);

    int insert(@Param("name") String name, @Param("age") Integer age);

    int insertByMap(Map<String, Object> map);

    int insertByUser(User user);
}
