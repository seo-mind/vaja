package com.example.demo.springjwt.payload.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank
	private String memberId;
	
	@NotBlank
	private String password;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
