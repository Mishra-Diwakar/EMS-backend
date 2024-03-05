package com.clickncash.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clickncash.entity.User;
import com.clickncash.repository.UserRepository;
import com.google.gson.Gson;

import liquibase.pro.packaged.iF;

@RestController
@RequestMapping("/rest/auth/user")
public class UserController {
	
	List<User> users = new ArrayList<User>();
	@PostMapping("/add")
	public HashMap<String, Object> postMethodName(@RequestBody User entity) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();

		try {
			users.add(entity);
			returnMap.put("isError", false);
			returnMap.put("msg", "user created");
			return returnMap;
		} catch (Exception e) {
			returnMap.put("isError", true);
			returnMap.put("msg", "user not created");
			return returnMap;
		}
		
	}
	



	
	
	

}
