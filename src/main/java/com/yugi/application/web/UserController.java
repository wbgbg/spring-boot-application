package com.yugi.application.web;

import com.yugi.application.DAO.Mapper;
import com.yugi.application.DO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private Mapper mapper;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping(method = RequestMethod.GET, value="/user/{id}")
    public User getUser(@PathVariable("id") long id) {
        System.out.println(id);
        User user = mapper.getUser(id);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value="/users")
    public List<User> getUsers() {
        List<User> users = mapper.getUsers();
        return users;
    }

    @RequestMapping(method = RequestMethod.POST, value="/user")
    public String addUser(@RequestBody User user) {
        System.out.println(user.getUserName());
        System.out.println(user.getPassWord());
        mapper.addUser(user);
        return "Success";
    }
}
