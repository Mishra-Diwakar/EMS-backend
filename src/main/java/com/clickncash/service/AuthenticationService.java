package com.clickncash.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clickncash.entity.User;
import com.clickncash.model.UserPrincipal;
import com.clickncash.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userRepository.getUserByUserName(Long.parseLong(loginId))
					.orElseThrow(() -> new UsernameNotFoundException(
							"User not found with Email/Network Id/Employee Id : " + loginId));
			if (user.getStatus().equalsIgnoreCase("deactive")) {
				System.out.println("User deactive");
				return null;
			}
		} catch (Exception e) {
			user = userRepository.getUserByUserName2(loginId).orElseThrow(() -> new UsernameNotFoundException(
					"User not found with Email/Network Id/Employee Id : " + loginId));
		}
		return UserPrincipal.create(user);
	}
}