package com.infosys.com.dto;

import javax.validation.constraints.NotEmpty;

public class LoginDetails {
	private String userId;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
