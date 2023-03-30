package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.TbRolesTest;
import com.example.demo.model.ERole;


public interface RoleRepository extends JpaRepository<TbRolesTest, Long> {

	Optional<TbRolesTest> findByMemberid(ERole name);
	
}
