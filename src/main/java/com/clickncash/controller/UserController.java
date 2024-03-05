package com.clickncash.controller;

import java.sql.Timestamp;
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

import com.clickncash.ImageUploader.Images;
import com.clickncash.entity.User;
import com.clickncash.model.UserRequest;
import com.clickncash.repository.UserRepository;
import com.clickncash.service.UserService;
import com.clickncash.utils.ClicknCashUtils;
import com.google.gson.Gson;

import liquibase.pro.packaged.iF;

@RestController
@RequestMapping("/rest/auth/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	@GetMapping("/all")
	private List<User> allUsers(HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return this.userRepository.findAll();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	



	@GetMapping("/all/{page}/{record}")
	private Page<User> getAllUsers(@PathVariable("page") Integer page, @PathVariable("record") Integer record,
			HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			Pageable pageable = PageRequest.of(page, record);
			User user = userRepository.findById(userId).get();
			if (user.getUserType()==1) {
				System.out.println("comes for all users");
				return userRepository.findAllUser(1, pageable);
			}else {
				return userRepository.findAllByUserType(3L, pageable);
			}
			
//			return this.userRepository.getAllUsers(pageable);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}


	@PostMapping("/get")
	private User getOneUser(@RequestBody User user, HttpServletRequest request) {
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				System.out.println(" @@@ user not found of this userId @@@");
				return null;
			}
			return this.userRepository.findById(user.getId()).get();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}


	@PostMapping("/create")
	private HashMap<String, Object> createUser(@RequestBody User userRequest,
			HttpServletRequest request) {
		Gson gson = new Gson();
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				returnMap.put("isError", true);
				returnMap.put("msg", "Invalid Token found");
				return returnMap;
			}
			List<User> isExists = userRepository.isExists(userRequest.getMobile(), userRequest.getEmail(),
					userRequest.getUsername(), userRequest.getAadhar());
			if (isExists.size() != 0) {
				returnMap.put("isError", true);
				returnMap.put("msg", "User all ready exists..");
				return returnMap;
			}
			User user = userService.saveUser(false, userRequest);
			if (user==null) {
				returnMap.put("isError", true);
				returnMap.put("msg", "User not created");
				return returnMap;
			}
			user.setCreatedBy(userId);
			userRepository.save(user);
			returnMap.put("isError", false);
			returnMap.put("msg", "User created successfully.");
			return returnMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			returnMap.put("msg", "Getting exception...");
			returnMap.put("isError", true);
			return returnMap;
		}
	}
	@PostMapping("/update")
	private HashMap<String, Object> updateUser(@RequestBody User userRequest,
			HttpServletRequest request) {
		Gson gson = new Gson();
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			Long userId = null;
			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				returnMap.put("isError", true);
				returnMap.put("msg", "Invalid Token found");
				return returnMap;
			}
			User user2 = userRepository.findById(userRequest.getId()).get();
			List<User> isExists2 = userRepository.isExists2(userRequest.getMobile(), userRequest.getEmail(),
					userRequest.getUsername(), userRequest.getAadhar(),user2.getId());
			if (isExists2.size() != 0) {
				returnMap.put("isError", true);
				returnMap.put("msg", "<small>User all ready exists..</small>");
				return returnMap;
			}
			User user = userService.saveUser(true, userRequest);
			if (user==null) {
				returnMap.put("isError", true);
				returnMap.put("msg", "User not updated");
				return returnMap;
			}
			user.setUpdatedBy(userId);
			user.setPassword(user2.getPassword());
			userRepository.save(user);
			returnMap.put("isError", false);
			returnMap.put("msg", "<small>User updated successfully.<small>");
			return returnMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			returnMap.put("msg", "Not updated");
			returnMap.put("isError", true);
			return returnMap;
		}
	}
	@PostMapping("/delete")
	private Map<String, Object> deleteUser(@RequestBody User u, HttpServletRequest request) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			Long userId = null;

			if (request.getAttribute("userId") != null) {
				userId = Long.valueOf(request.getAttribute("userId").toString());
			} else {
				returnMap.put("isError", true);
				returnMap.put("msg", "User not found for this transaction.");
				return returnMap;
			}
			User user = userRepository.findById(u.getId()).get();
			user.setStatus("DEACTIVE");
			user.setUpdatedAt(new Timestamp(new Date().getTime()));
			userRepository.save(user);
			returnMap.put("isError", false);
			returnMap.put("msg", "User deleted");
			return returnMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			returnMap.put("msg", "User not deleted");
			returnMap.put("isError", true);
			return returnMap;
		}

	}





	
	
	

}
