package com.hl.springbootdemo1.chapter23.service;

import com.hl.springbootdemo1.chapter23.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(String name, Integer age) {
        return jdbcTemplate.update("INSERT INTO USER(NAME, AGE) VALUES(?, ?)", name, age);
    }

    @Override
    public List<User> getByName(String name) {
        List<User> userList = jdbcTemplate.query("select name,age from user where name = ?", (resultSet, i) -> {
            User user = new User();
            user.setName(resultSet.getString("NAME"));
            user.setAge(resultSet.getInt("AGE"));
            return user;
        }, name);
        return userList;
    }

    @Override
    public int deleteByName(String name) {
        return jdbcTemplate.update("delete from user where name = ?", name);
    }

    @Override
    public int getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    @Override
    public int deleteAllUsers() {
        return jdbcTemplate.update("delete from user");
    }
}
