package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.TbMemberTest;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Service
@Transactional
public class MemberDetailsImpl implements UserDetails  {
	
	private static final long serialVersionUID = 1L;

	private Long memberNo;

	private String memberId;

	private String email;
	
	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;


	public MemberDetailsImpl(Long memberNo, String memberId, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	

	public static MemberDetailsImpl build(TbMemberTest user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new MemberDetailsImpl(
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MemberDetailsImpl user = (MemberDetailsImpl) o;
		return Objects.equals(memberId, user.memberId);
	}

}
