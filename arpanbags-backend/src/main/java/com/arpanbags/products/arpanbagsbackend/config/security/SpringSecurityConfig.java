package com.arpanbags.products.arpanbagsbackend.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.arpanbags.products.arpanbagsbackend.config.security.jwt.JWTAuthenticationEntryPoint;
import com.arpanbags.products.arpanbagsbackend.config.security.jwt.JWTAuthenticationFilter;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Step 1 -> To create security filter chain if JWTTokenFilter is created then
 * STEP 1 will be that JWTTokenFilter file otherwise this security Filter Chain
 * will be first file.
 * 
 * 
 * @author Arpan Kumar
 *
 *         Here In this Filter class will execute before Executing Spring
 *         Securit Filters It Validates the JWT Token and provides user details
 *         to Spring Securit for Authentication
 *
 *
 */

//@EnableMethodSecurity --this is used if we want to perform method level security in controller class 
@EnableWebSecurity
@Configuration
@EnableMethodSecurity
@Slf4j
@EnableAsync
public class SpringSecurityConfig {

	// STEP -4 inject UserDetailsService into this config class to work on DB
	// authentication

	/**
	 * This will be called automatically here in Spring Security 6.0
	 * .userDetailsService(userDetailsService) and inject its loadByUserName MTHOD
	 */
	@Bean
	 public  UserDetailsService userDetailsService() {
		return new UserInfoManagerConfig();
	}

	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JWTAuthenticationFilter jwtAuthFilter;

	
	/**
	 * 
	 * Here it is mandatory to understand that whenever we define our securityfileterchain in that case 
	 * we will use securityMatcher(new AntPathRequestMatcher("/myWebApp/v1/api/products/**")) 
	 * AntPathRequestMatcher to restrict the urls and 
	 * 
	 * .authorizeHttpRequests(auth -> auth.requestMatchers("/myWebApp/authenticate/**").permitAll())
	 * this will permitAll the URLs this will be in the second line, we can also use Order(An inte number)
	 * this will prioritize the ordering of security in desc order means if Order(1) is highly working than 
	 * Order(2) 
	 * 
	 * 
	 * I took 4 hours to understand this.but finally i did it.
	 * 
	 * Second point in JWTAuthFilter we can use 
	 * if (Objects.isNull(authHeader) || !authHeader.startsWith("Bearer")) {  
	 * 
	 * line to byPass the request from Filter thats why permitAll works as register url 
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Order(1)
	@Bean
	public SecurityFilterChain signInSecurityFilterChain(HttpSecurity http) throws Exception {
		return http.securityMatcher(new AntPathRequestMatcher("/myWebApp/authenticate/login"))
				   .csrf((csrf) -> csrf.disable())
				   .cors((cors) -> cors.disable())
				   .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
				   .userDetailsService(userDetailsService())
				   .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				   .exceptionHandling(ex -> {
					ex.authenticationEntryPoint((request, response, authException) -> response
							.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage()));
				   })
				   .httpBasic(Customizer.withDefaults())
				   .build();
	}
	
	
	@Order(2)
    @Bean
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .securityMatcher(new AntPathRequestMatcher("/myWebApp/v1/api/products/**"))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.anyRequest().fullyAuthenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(ex -> {
                    log.error("[SecurityConfig:apiSecurityFilterChain] Exception due to :{}",ex);
                    ex.authenticationEntryPoint(jwtAuthenticationEntryPoint);
                    ex.accessDeniedHandler(new BearerTokenAccessDeniedHandler());
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }
	
	@Order(3)
    @Bean
    public SecurityFilterChain registerSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .securityMatcher(new AntPathRequestMatcher("/myWebApp/authenticate/register"))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().permitAll())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
	
	@Bean
    public SecurityContextRepository securityContextRepository(){
        return new NullSecurityContextRepository(); // I use Null Repository since I don't need it for anything except store information in UserDetails
    }

	
	/**
	@Order(2)
	@Bean
	public SecurityFilterChain registerSecurityFilterChain(HttpSecurity http) throws Exception {
		return http.securityMatchers((matchers)-> matchers.requestMatchers("/myWebApp/authenticate/**"))
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
				//.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.httpBasic(Customizer.withDefaults()).build();
	}
    */
	/**	
		 **/
	/**
	 * 
	 * http.authorizeHttpRequests((authorize)->{
	 * authorize.requestMatchers(AUTH_WHITELIST).hasRole("ADMIN");
	 * }).sessionManagement(session ->
	 * session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	 * .httpBasic(Customizer.withDefaults()); return http.build();
	 * 
	 * 
	 */

	private static final String[] AUTH_WHITELIST = { "/myWebApp/authenticate/**", "/swagger-ui/**" };

	/**
	 * STEP -5 PasswordEncoder
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 
	 * STEP -6 Creating AuthenticationManager is configured now Now
	 * AuthenticationManager is created which will interact to AuthProvider
	 * internally **
	 * 
	 * @param authenticationConfiguration
	 * @return
	 * @throws Exception
	 */

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		log.info("AuthenticationProvider :: authenticationProvider");
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

}

/***
 * --- LDAP AUTHENTICATION PROVIDER SECURITY FILTER CHAIN
 * 
 * --- LDAP stands for Lightweight Directory Access Protocol. It is an open,
 * vendor-neutral, industry standard application protocol to access and maintain
 * distributed directory information services over the network.
 * 
 * --- LDIF is an abbreviation for LDAP Data Interchange Format. It is a
 * standard plain text data interchange format of a file that is used for
 * representing LDAP directory content. The extension of the file is ‘.ldif’.
 * There are multiple fields in the LDIF file. Let’s know about them:
 * 
 * @Configuration public class LdapSecurityConfig {
 * 
 *                protected SecurityFilterChain filterChain(HttpSecurity http)
 *                throws Exception {
 * 
 *                http .authorizeHttpRequests()
 *                .anyRequest().fullyAuthenticated() .and() .formLogin();
 *                http.authenticationProvider(ldapAuthenticationProvider());
 *                return http.build(); }
 * 
 * @Bean LdapAuthenticationProvider ldapAuthenticationProvider() { return new
 *       LdapAuthenticationProvider(authenticator()); }
 * 
 * @Bean BindAuthenticator authenticator() {
 * 
 *       FilterBasedLdapUserSearch search = new
 *       FilterBasedLdapUserSearch("ou=groups", "(uid={0})", contextSource());
 *       BindAuthenticator authenticator = new
 *       BindAuthenticator(contextSource());
 *       authenticator.setUserSearch(search); return authenticator; }
 * 
 * @Bean public DefaultSpringSecurityContextSource contextSource() {
 *       DefaultSpringSecurityContextSource dsCtx = new
 *       DefaultSpringSecurityContextSource("ldap://localhost:8389/dc=springframework,dc=org");
 *       dsCtx.setUserDn("uid={0},ou=people"); return dsCtx; } }
 * 
 * 
 */

/**
 * //.cors((cors) -> cors.disable()) //.authorizeHttpRequests((authorize) -> {
 * // authorize.anyRequest().hasAnyRole(roles) //
 * authorize.requestMatchers("").permitAll(); // STEP -11 to apply the register
 * API details need to be define here //
 * authorize.requestMatchers("/api/auth/login","/v1/api/products/**").authenticated();
 * // authorize.requestMatchers("/api/auth/register").permitAll(); //}) //
 * .authenticationProvider(authenticationProvider)
 * 
 * 
 * 
 */
