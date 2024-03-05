package com.clickncash;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		int min = 10000001;
		int max = 99999999;
		int a = (int)(Math.random()*(max-min+1)+min);  
		
		int min1 = 10000001;
		int max1 = 99999999;
		int b = (int)(Math.random()*(max1-min1+1)+min1);  
		
		String agentId = "RAI" + a +""+ b;
		System.out.println(agentId);
		
		
		String password = "admin12#";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String testPasswordEncoded = passwordEncoder.encode(password);
        System.out.print("encoded password = "+testPasswordEncoded);
	}
}
