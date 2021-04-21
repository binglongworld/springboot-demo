package com.hl.chapter31.mapper;

import com.hl.chapter31.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@Mapper
@CacheConfig(cacheNames = "user")
public interface UserMapper {
    int deleteUser();

    @Cacheable
    User findByName(@Param("name") String name);

    int insert(@Param("name") String name, @Param("age") Integer age);

}
