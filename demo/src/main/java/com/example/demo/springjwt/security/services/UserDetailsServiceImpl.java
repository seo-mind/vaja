package com.example.demo.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.springjwt.models.TbMemberTest;
import com.example.demo.springjwt.repository.MemberRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		
		TbMemberTest user = memberRepository.findByMemberid(memberId)
				.orElseThrow(()-> new UsernameNotFoundException("User Not Found with memberId: " + memberId ) );//Null 체크를 위해
		return UserDetailsImpl.build(user);
	}

}
