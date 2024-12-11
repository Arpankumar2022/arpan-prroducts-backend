package com.arpanbags.products.arpanbagsbackend.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetailObject implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private  UserInfo userInfo;
	
	
    private Long id;
	
	private String userName;
	
	private String emailId;
	
	
	private String password;
	
	private String mobileNum;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	 public static UserDetailObject create(UserInfo userInfo) {
	        List<GrantedAuthority> authorities = userInfo.getRoles().stream().map(role ->
	                new SimpleGrantedAuthority(role.getRoleName())
	        ).collect(Collectors.toList());
	        return new UserDetailObject(
	        		userInfo.getId(),
	        		userInfo.getUserName(),
	        		userInfo.getEmailId(),
	        		userInfo.getPassword(),
	        		userInfo.getMobileNum(),
	                authorities
	        );
	    }


	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	


}
