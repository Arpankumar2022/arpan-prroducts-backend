package com.arpanbags.products.arpanbagsbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arpanbags.products.arpanbagsbackend.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	 Optional<Role>  findByRoleName(String roleName);
	
}
