package com.arpanbags.products.arpanbagsbackend.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arpanbags.products.arpanbagsbackend.config.security.jwt.JWTTokenProvider;
import com.arpanbags.products.arpanbagsbackend.dto.AuthResponse;
import com.arpanbags.products.arpanbagsbackend.dto.LoginDTO;
import com.arpanbags.products.arpanbagsbackend.dto.RegisterDTO;
import com.arpanbags.products.arpanbagsbackend.entity.Role;
import com.arpanbags.products.arpanbagsbackend.entity.UserInfo;
import com.arpanbags.products.arpanbagsbackend.exception.APIException;
import com.arpanbags.products.arpanbagsbackend.repository.RoleRepository;
import com.arpanbags.products.arpanbagsbackend.repository.UserInfoRepository;


/**
 * STEP -8 
 * 
 *  Now we need to create AuthService which will create register user in the DB
 *  If exists already then will redirect to login 
 * 
 * @author Arpan kumar
 *
 */

/**
 * Since Spring 6.0 we have ProblemDetail class which can help to show
 * httpStatus messages
 *
 * private ProblemDetail problemDetail =
 * ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "User Already Exists
 * !!");
 *
 */

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserInfoRepository userInfoRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JWTTokenProvider jwtTokenProvider;

	/**
	 * We are going to use authenticate() method of this class hence we need this
	 * AUTHMANAGER becuase it is main gate for all incoming requests which it will
	 * create to authenticate process.
	 */
	@Autowired
	private AuthenticationManager authManager;

	@Override
	public String register(RegisterDTO registerDTO) {

		// Check username is exists already or not

		if (userInfoRepo.existsByEmailId(registerDTO.getEmail())) {
			throw new APIException(HttpStatus.BAD_REQUEST, "UserName Already Exists !!");
		}

		/**
		 * STEP - 8 part 2 User object is created and it will be set into DB
		 */
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(registerDTO.getUserName());
		userInfo.setEmailId(registerDTO.getEmail());
		userInfo.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
		userInfo.setMobileNum(registerDTO.getMobNum());
		// userInfo.setRoles(registerDTO.getRoles());
		/**
		 * STEP - 8 part 3
		 * 
		 * Need to manage the Roles and looking into query coming from UI whether it is
		 * available in DB or not
		 */
		Set<Role> setOfRoles = new HashSet<>();
		Role role = new Role();
		role.setRoleName(registerDTO.getRoles());
		setOfRoles.add(role);
		// TODO
		for (Role roleVal : setOfRoles) {
			Optional<Role> roleValueDb = Optional.ofNullable(roleRepo.findByRoleName(roleVal.getRoleName())).get();
			if(roleValueDb.isPresent()){
				Role roleDB  =  roleValueDb.get();	
				userInfo.setRoles(Set.of(roleDB));
			}else {
				throw new UsernameNotFoundException("User is  not present with this Role");
			}
		}
		
		/**
		 * STEP - 8 part 4
		 */
		userInfoRepo.save(userInfo);

		return "User Registered Successfully !!";
	}

	/**
	 * STEP - 12 , We can create this Login API method after STEP-6 as well but
	 * firstly we created RegisterDTO and Doing all registration steps we can do
	 * this CREATION of LoginDTO api.
	 */

	@Override
	public AuthResponse login(LoginDTO loginDTO) {

		Authentication authentication = authManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDTO.getUserNameOrEmail(), loginDTO.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
        /**
         * STEP - 16 - SEND BACK RESPONSE TO THE USER RELATED TO ROLES AND TOKEN DETAILS 
         * 
         */
		String accessToken = jwtTokenProvider.generateToken(authentication);
		Set<Role> roles = new HashSet<>();
		Optional<UserInfo> userOpt = userInfoRepo.findByEmailId(loginDTO.getUserNameOrEmail());
		if (userOpt.isPresent()) {
			UserInfo loggedUserInfo = userOpt.get();
			roles.addAll(!loggedUserInfo.getRoles().isEmpty() ? loggedUserInfo.getRoles() : Collections.emptySet());

		}
		AuthResponse authResponse = new AuthResponse();
		authResponse.setAccessToken(accessToken);
		authResponse.setRoles(roles);

		return authResponse;
	}

}
