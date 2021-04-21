package com.hl.example.mapper.primary;

import com.hl.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface UserMapperPrimary {
    int deleteUser();

    User findByName(@Param("name") String name);

    int insert(@Param("name") String name, @Param("age") Integer age);

    int insertByMap(Map<String, Object> map);

    int insertByUser(User user);
}
