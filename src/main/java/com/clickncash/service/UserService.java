package com.clickncash.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clickncash.entity.User;
import com.clickncash.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	
	public HashMap<String, Object> generateNewPassword(String emailId) {
		HashMap<String, Object> returnMap = new HashMap<>();
		User user = userRepository.findByEmail(emailId);
		if(user != null) {
			String newPassword = RandomStringUtils.randomAlphanumeric(12);
			System.out.println(newPassword);
			user.setPassword(passwordEncoder.encode(newPassword));
			userRepository.save(user);
			String message = "<div>Hello " + user.getName() + ",</div><br/><div>Please use <strong>" + newPassword
					+ "</strong> as password to login into your account. It is recommended that you change your password after login.</div><br/><div>Thanks,</div><div>Wallet Pay</div>";
			emailService.sendMail(emailId, "New Password generated", message);
			returnMap.put("isError", false);
			returnMap.put("msg", "Password is shared with your email id.");
		}else {
			returnMap.put("isError", true);
			returnMap.put("msg", "User not found for this transaction.");
		}
		return returnMap;
	}
	
	
	public static int generateRandomNumber(){
		int min = 50000000;  
		int max = 99999999;  
		int b = (int)(Math.random()*(max-min+1)+min);  
		return b;
	}
	public User findByUsername(String username) {
		return userRepository.getUserByUserName2(username).get();
	}
	
	public String encodedString(String str) {
		return passwordEncoder.encode(str);
	}
	
	public User saveUser(boolean isEdit,User userRequest) {
		try {
			if (isEdit) {
				userRequest.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				userRequest.setStatus(userRequest.getStatus());
				return userRequest;
			}
			userRequest.setStatus("ACTIVE");
			userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
			userRequest.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			
			return userRequest;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
//	for login attempt
	
    public static final int MAX_FAILED_ATTEMPTS = 5;
    
    private static final long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 hours
     
    @Autowired
    private UserRepository repo;
     
    public void increaseFailedAttempts(User user) {
        int newFailAttempts = user.getFailedAttempt() + 1;
        repo.updateFailedAttempts(newFailAttempts, user.getUsername());
    }
     
    public void resetFailedAttempts(String username) {
        repo.updateFailedAttempts(0, username);
    }
     
    public void lock(User user) {
        user.setAccountNonLocked(false);
        user.setLockTime(new Date());
         
        repo.save(user);
    }
     
    public boolean unlockWhenTimeExpired(User user) {
        long lockTimeInMillis = user.getLockTime().getTime();
        long currentTimeInMillis = System.currentTimeMillis();
         
        if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
            user.setAccountNonLocked(true);
            user.setLockTime(null);
            user.setFailedAttempt(0);
             
            repo.save(user);
             
            return true;
        }
         
        return false;
    }
}
