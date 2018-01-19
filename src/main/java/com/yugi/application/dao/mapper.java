package com.yugi.application.DAO;

import com.yugi.application.DO.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Mapper {
    @Select("SELECT * FROM users WHERE id = ${id}")
    User getUser(long id);

    @Select("Select * FROM users")
    List<User> getUsers();

    @Insert("INSERT INTO users(userName, passWord) VALUES(#{userName}, #{passWord})")
    void addUser(User user);
}
