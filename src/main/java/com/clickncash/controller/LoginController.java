package com.clickncash.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clickncash.entity.User;
import com.clickncash.exception.FieldException;
import com.clickncash.model.AuthRequest;
import com.clickncash.model.AuthResponse;
import com.clickncash.model.Response;
import com.clickncash.repository.UserRepository;
import com.clickncash.service.UserService;
import com.clickncash.utils.AuthTokenUtil;

@RestController
@RequestMapping("/rest/auth")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthTokenUtil tokenProvider;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) throws FieldException {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = userRepository
				.getUserByUserName2(authRequest.getUsername()).get();
		String status = user.getStatus();
		if (status.equalsIgnoreCase("deactive")) {
			Response<AuthResponse> response = new Response<>();
			response.setErrors(Arrays.asList("Deactivated"));
			return ResponseEntity.ok().body(response);
		}
		String jwt = tokenProvider.generateToken(authentication);
		//String permission = this.mergeUserPerissions(user.getRoles());
		user.setLoginTime(new Timestamp(System.currentTimeMillis()));
		userRepository.save(user);
		Response<AuthResponse> response = new Response<>();
		response.setMessages(Arrays.asList("Token Generated Successfully.")); //Arrays.asList(environment.getProperty("token.generated"))
		response.setPayload(new AuthResponse(jwt, user, null));
		return ResponseEntity.ok().body(response);
	}
	
	
	@PostMapping("/signup")
	public HashMap<String, Object> signUp(@RequestBody User user) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		try {
//			user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
//			user.setCreatedBy(0L);
//			user.setPassword(userService.encodedString(user.getPassword()));
//			user.setUserType(1L);
//			user.setStatus("ACTIVE");
			System.out.println("username:"+user.getUsername());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			
			returnMap.put("isError", false);
			returnMap.put("msg", "Account created successfully..");
			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("isError", true);
			returnMap.put("msg", "Account not created..!");
			return returnMap;
		}
	}	
}
