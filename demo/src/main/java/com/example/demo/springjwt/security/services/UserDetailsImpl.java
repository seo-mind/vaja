package com.example.demo.springjwt.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.springjwt.models.TbMemberTest;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class UserDetailsImpl implements UserDetails  {
	
	private static final long serialVersionUID = 1L;

	private Long memberNo;

	private String memberId;

	private String email;
	
	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;


	public UserDetailsImpl(Long memberNo, String memberId, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	

	public static UserDetailsImpl build(TbMemberTest user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getMemberNo() , 
				user.getMemberId(), 
				user.getEmail(),
				user.getPassword(), 
				authorities);
	}	


	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return memberId;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}



	public Long getMemberNo() {
		return memberNo;
	}


	public String getEmail() {
		return email;
	}
	
	public String getMeberId() {
		return memberId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(memberNo, user.memberNo);
	}

}
