package com.hl.chapter21.mapper;

import com.hl.chapter21.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface UserMapper {
    @Delete("DELETE FROM USER")
    int deleteUser();

    @Select("SELECT USER.ID,USER.NAME,USER.AGE FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME,AGE) VALUES(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO USER(NAME,AGE) VALUES(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO USER(NAME,AGE) VALUES(#{name},#{age})")
    int insertByUser(User user);
}
