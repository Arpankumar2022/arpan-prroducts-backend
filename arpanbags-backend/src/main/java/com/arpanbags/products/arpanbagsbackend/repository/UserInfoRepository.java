package com.arpanbags.products.arpanbagsbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpanbags.products.arpanbagsbackend.entity.UserInfo;


@Repository
public interface UserInfoRepository  extends JpaRepository<UserInfo, Long> {
	
	
	Optional<UserInfo> findByEmailId(String emailId);
	
	Boolean existsByEmailId(String emailId);
	
	
	Optional<UserInfo> findByUserNameOrEmailId(String userName, String emailId); 

}
