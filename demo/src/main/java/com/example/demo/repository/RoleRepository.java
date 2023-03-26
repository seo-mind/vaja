package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.TbRolesTest;
import com.example.demo.model.ERole;


/**
 * User: HolyEyE
 * Date: 2013. 12. 3. Time: 오전 1:08
 */
public interface RoleRepository extends JpaRepository<TbRolesTest, Long> {

	Optional<TbRolesTest> findByMemberid(ERole name);
	
}
