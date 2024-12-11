package com.arpanbags.products.arpanbagsbackend.config.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arpanbags.products.arpanbagsbackend.entity.UserDetailObject;
import com.arpanbags.products.arpanbagsbackend.entity.UserInfo;
import com.arpanbags.products.arpanbagsbackend.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * STEP -3 after USER AND ROLES while creating user credentials to be connect to
 * DB
 * 
 * @author Arpan
 *
 */

@Service
@RequiredArgsConstructor
public class UserInfoManagerConfig implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

		UserInfo user = userInfoRepo.findByUserNameOrEmailId(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User Email is not found !!")); 
		/**
		 * Spring Security wants roles to be in GrantedAuthority
		 *  format thats why we converted it into GrantedAuthority
		 */
		
        /**
         * Spring Security wants values in the form of User given by Security 
         * this user object will be returned by Security
         * 
         */
		return UserDetailObject.create(user);
	}

}
