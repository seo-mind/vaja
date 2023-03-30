package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.TbMemberTest;


public interface MemberRepository extends JpaRepository<TbMemberTest, Long> {

	Optional<TbMemberTest> findByMemberid(String member_id);
	
	Boolean existsByMemberid(String member_id);
	Boolean existsByEmail(String email);
	
}
