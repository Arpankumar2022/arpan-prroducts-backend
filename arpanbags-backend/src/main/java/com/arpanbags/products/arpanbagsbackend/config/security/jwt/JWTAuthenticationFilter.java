package com.arpanbags.products.arpanbagsbackend.config.security.jwt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import  com.arpanbags.products.arpanbagsbackend.config.security.jwt.*;

/**
 * 
 * 
 * 
 * @author Arpan Kumar
 * 
 *         This Filter class will execute before Executing Spring Securit
 *         Filters It Validates the JWT Token and provides user details to
 *         Spring Securit for Authentication
 *
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

	private  final JWTTokenProvider jwtTokenProvider;


	// private UserDetailsService userDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = null;
		String userName = null;

		log.info("[JWTAuthenticationFilter:doFilterInternal] :: Started ");

		log.info("[JWTAuthenticationFilter:doFilterInternal]Filtering the Http Request:{}", request.getRequestURI());

		// if (!requestURL.matches(request)) {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (isExcluded(request.getRequestURI())) {
			filterChain.doFilter(request, response);
			return;
		}

		/**
		 * if (Objects.isNull(authHeader) || !authHeader.startsWith("Bearer")) {
		 * 
		 * THIS WILL BY PASS THE INCOMING REQUESTS TO REGISTER THE USER
		 * 
		 * 
		 */
		/**
		 * if (!authHeader.startsWith("Bearer")) { filterChain.doFilter(request,
		 * response); return; }
		 */

		if (Objects.nonNull(authHeader) && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			userName = jwtTokenProvider.getUserName(token);
			if (Objects.isNull(userName)) {
				filterChain.doFilter(request, response);
				return;
			}
			if (Objects.nonNull(userName) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {

				// We can also use here loadUserByUsername of UserDetailService
				UserDetails userDetails = jwtTokenProvider.userDetails(userName);

				if (jwtTokenProvider.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
							null, userDetails.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authToken);
					log.info(
							"Authentication has user name : " + ((UserDetails) authToken.getPrincipal()).getUsername());

				}

			}

		}

		// }
		filterChain.doFilter(request, response);
	}

	private boolean isExcluded(String requestURI) {
		String uri = null;
		if (requestURI.contains("/myWebApp/authenticate")) {
			uri = requestURI.substring("/myWebApp/authenticate".length());
		} else {
			uri = requestURI;
		}
		return Arrays.stream(AUTH_WHITELIST).anyMatch(uri::equals);
	}

	private static final String[] AUTH_WHITELIST = { "/register", "/login" };

}
