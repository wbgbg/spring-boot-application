package com.yugi.application.DAO;

import com.yugi.application.DO.User;
import org.apache.ibatis.annotations.*;


public interface Mapper {
    @Select("SELECT * FROM users WHERE id = ${userId}")
    User getUser(long userId);
}
