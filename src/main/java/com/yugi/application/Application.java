package com.yugi.application;

import com.yugi.application.DAO.Mapper;
import com.yugi.application.DO.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@MapperScan("com.yugi.application.DAO")
public class Application {

	@Autowired
	private Mapper mapper;

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/getUser")
	public User getUser(Long id) {
		User user = mapper.getUser(id);
		return user;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}