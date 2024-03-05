package com.clickncash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clickncash.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean checkLogin() {
		//this.userRepository.findById();
		
		return false;
	}
}
