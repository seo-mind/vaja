package com.example.demo.springjwt.payload.request;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignupRequest {
	
	@NotBlank
	@Size(min=5, max=20)
	private String memberId;
	
	@NotBlank
	@Size(max=50)
	private String email;
	
	@NotBlank
	private String name;
	
	private Set<String> role;
	
	@NotBlank
	@Size(min=5, max=40)
	private String password;
	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
