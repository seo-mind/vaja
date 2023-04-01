package com.example.demo.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springjwt.models.TbMemberTest;


public interface MemberRepository extends JpaRepository<TbMemberTest, Long> {

	Optional<TbMemberTest> findByMemberId(String member_id);
	
	Boolean existsByMemberId(String member_id);
	Boolean existsByEmail(String email);
	
}
