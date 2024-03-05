package com.clickncash.model;

import java.io.Serializable;

import com.clickncash.entity.User;


public class AuthResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	private User user;

	private String permission;

	public AuthResponse(String jwttoken, User user, String permission) {
		this.jwttoken = jwttoken;
		this.user = user;
		this.permission = permission;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public User getUser() {
		return user;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
