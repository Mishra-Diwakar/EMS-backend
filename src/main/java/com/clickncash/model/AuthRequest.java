package com.clickncash.model;

import java.io.Serializable;
import java.util.List;

public class AuthRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;

	private String username;
	private String password;
	private List<String> role;

	public AuthRequest() {
	}

	public AuthRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public List<String> getRole() {
		return role;
	}

	public void setRole(List<String> role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}