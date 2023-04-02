package com.example.demo.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springjwt.models.ERole;
import com.example.demo.springjwt.models.TbMemberTest;
import com.example.demo.springjwt.models.TbRolesTest;
import com.example.demo.springjwt.payload.request.LoginRequest;
import com.example.demo.springjwt.payload.request.SignupRequest;
import com.example.demo.springjwt.payload.response.JwtResponse;
import com.example.demo.springjwt.payload.response.MessageResponse;
import com.example.demo.springjwt.repository.MemberRepository;
import com.example.demo.springjwt.repository.RoleRepository;
import com.example.demo.springjwt.security.jwt.JwtUtils;
import com.example.demo.springjwt.security.services.UserDetailsImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*", maxAge=3600) // 60분*60초
@RequestMapping("/api/test")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getMemberId() , loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl)authentication.getPrincipal();
		
		// stream - 일회성 읽기 ( 반복분 쓸때 자주 씀 )
		// map  입력 T 타입을 R 타입 요소로 변환한 스트림 생성
		//Collectors.toList stream의 요소를 수집하여 요소를 그룹화 하거나 결과를 담아 반환하는데 사용한다.
		List<String> roles = userDetailsImpl.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		
		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetailsImpl.getMemberNo()  ,
												 userDetailsImpl.getMeberId(),
												 userDetailsImpl.getEmail(),
												 roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		if (memberRepository.existsByMemberId(signupRequest.getMemberId())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error : Id is already taken!"));
		}
		
		if (memberRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error : Email is already use!"));
		}
		
		TbMemberTest user = new TbMemberTest(signupRequest.getName()
											, signupRequest.getMemberId()
											, signupRequest.getEmail()
											, passwordEncoder.encode(signupRequest.getPassword()));
		
		Set<String> strRoles = signupRequest.getRole();
		Set<TbRolesTest> roles = new HashSet<>();
		
		if (strRoles == null ) {
			TbRolesTest userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(()-> new RuntimeException("Error : Role is not found."));
			roles.add(userRole);
		}else {
			// User 권한을 받아올 경우 ex) 관리자 만들 경우?
			strRoles.forEach(role ->{	
				switch(role) {
				case "admin":
					TbRolesTest adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
						.orElseThrow(()->new RuntimeException("Error : Role is not found"));
					roles.add(adminRole);
					
					break;
				case "mod":
					TbRolesTest modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
						.orElseThrow(()->new RuntimeException("Error : Role is not found"));
					roles.add(modRole);
					
					break;
				default:
					TbRolesTest userRole = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(()->new RuntimeException("Error : Role is not found"));
					roles.add(userRole);
						
				}
			});
		}
		
		user.setRoles(roles);
		memberRepository.save(user);
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> userList(){
//		TbMemberTest customer = TbMemberTest ;
//		JPAQuery<?> query = new JPAQuery<Void>(entityManager);
//		Customer bob = query.select(customer)
//		  .from(customer)
//		  .where(customer.firstName.eq("Bob"))
//		  .fetchOne();

		return null;
		
	}
	
}
