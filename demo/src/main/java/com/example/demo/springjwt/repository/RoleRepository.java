package com.example.demo.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.springjwt.models.ERole;
import com.example.demo.springjwt.models.TbRolesTest;


public interface RoleRepository extends JpaRepository<TbRolesTest, Long> {

	Optional<TbRolesTest> findByMemberid(ERole name);
	
}
