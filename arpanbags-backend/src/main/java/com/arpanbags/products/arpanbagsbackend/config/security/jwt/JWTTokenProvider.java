package com.arpanbags.products.arpanbagsbackend.config.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.arpanbags.products.arpanbagsbackend.entity.UserDetailObject;
import com.arpanbags.products.arpanbagsbackend.exception.JWTExpiredException;
import com.arpanbags.products.arpanbagsbackend.repository.UserInfoRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@Service
public class JWTTokenProvider {
	
	
	/**
	 * STEP -15 
	 * 
	 * Create a JWTTokenProvider which contains some method that help us to play around JWT Tokens 
	 */
	public static final String ACCESS = "access";
	
	
	/**
	 * STEP - 15 - 1
	 */
	@Value("${jwt.jwtSecretKey}")
	private String sectretKey;
	
	@Value("${jwt.jwtExpiryTimeout-milliseconds}")
	private long expirationTime;
	
	
	//private final JwtEncoder jwtEncoder;
	/**
	 * STEP - 15 - 2
	 */
	private Map<String, String> userClaims = new ConcurrentHashMap<>();
	
	
	/**
	 * STEP - 15 - 3
	 */

	private final  UserInfoRepository userInfoRepo;
	/**
	 * 
	 * STEP -15 - 4 
	 * Generate JWT token 
	 * This is standard way to define the JWT Token creation.
	 * 
	 */
	
	public String generateToken(Authentication authentication) {
		
		log.info("JWTTokenProvider :: generateToken");
		//Step - a 
		String userName = authentication.getName();
		log.info("JWTTokenProvider :: userName"+userName);
		
		// Converting firstl milliseconds into minutes -- Not Required here 
		// Understanding about Time and Date  -- https://www.youtube.com/watch?v=KjfklDFiV_Q
		/**long minutes =	TimeUnit.MILLISECONDS.toMinutes(expirationTime);
		LocalDateTime expirationDateTime =  LocalDateTime.now().plusMinutes(minutes);
		
		ZonedDateTime.of(expirationDateTime, TimeZone.getTimeZone("ZONE").toZoneId()).toInstant();	**/

		// --- 
		
		
		/**

		//Step - d 
		String roles = getRolesOfUser(authentication);
		**/
		
		
		/**
		//Step - e
		String permissions = getPermissionsFromRoles(roles);
		**/
		
		
		// Step - g --> Claims to be set to create JWT token 
		Map<String, String> claims = new HashMap<>();
		String randomUUID = UUID.randomUUID().toString();
		claims.put(userName, randomUUID);
		claims.put("type", JWTTokenProvider.ACCESS);
		userClaims.put(userName, randomUUID);
		
		log.info("JWTTokenProvider :: generateToken  "+userClaims);
		
		//Step - f		
		//JWTs       which return JWts builder method whcich will set claims and issueAt , issue
		return Jwts.builder()
		   .setSubject(userName)
		  // .setClaims(claims)
		   .setIssuedAt(new Date(System.currentTimeMillis()))
		   .setExpiration(new Date(System.currentTimeMillis()+ expirationTime))
		   .signWith(getSignKey()).compact();
		
		/**
		JwtClaimsSet claimsSet = JwtClaimsSet.builder()
				  .subject(userName)
				  .issuer("ARPAN")
				  .issuedAt(Instant.now())
				  .expiresAt(Instant.now().plus(15, ChronoUnit.SECONDS))				  
				  .claim("scope", permissions)
				  .build();		
		
		    JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256).build();

		    SignedJWT signedJWT = new SignedJWT(header, claimsSet);
		    JWSSigner signer = new RSASSASigner(sectretKey);

		    signedJWT.sign(signer);
		
		**/
		
		
		
		//  Step - g  this step will encode JWT token with the help of jwtEncoder
	   	//return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet))..getTokenValue();
	}
	
	/**
	 * STEP - 15 - 5
	 */
	private Key getSignKey() {
		log.info("JWTTokenProvider :: getSignKey");
		byte[] keyBytes = Decoders.BASE64.decode(sectretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	/**
	//Step - c
	private String getPermissionsFromRoles(String roles) {
		Set<String> permissions = new HashSet<>();

		if (roles.contains("ROLE_ADMIN")) {
			permissions.addAll(List.of("READ", "WRITE", "DELETE"));
		}
		if (roles.contains("ROLE_MANAGER")) {
			permissions.add("READ");
		}
		if (roles.contains("ROLE_USER")) {
			permissions.add("READ");
		}

		return String.join(" ", permissions);
	}
	**/
	
	/**
	//Step - b	
	private static String getRolesOfUser(Authentication authentication) {
		return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
	}	
	
	**/
	
	/**
	 * STEP - 15 - 6
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		log.info("JWTTokenProvider :: extractClaim");
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	/**
	 * STEP - 15 - 7
	 */
	private Claims extractAllClaims(String token) {
		log.info("JWTTokenProvider :: extractAllClaims");
		Claims claims = null;
		try {
			log.info("JWTTokenProvider :: claims");
			claims = Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();

		} catch (ExpiredJwtException ex) {
			throw new JWTExpiredException("Access/Refresh token is invalid or has expired!!");
		}
		return claims;
	}
	
	/**
	 * STEP - 15 - 8
	 */
	public String extractUsername(String token) {
		log.info("JWTTokenProvider :: extractUsername");
		return extractClaim(token, Claims::getSubject);
	}
	
	/**
	 * STEP - 15 - 9
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		log.info("JWTTokenProvider :: validateToken");
		final String username = getUserName(token);
		return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
	}
	/**
	 * STEP - 15 - 10
	 */
	private Boolean isTokenExpired(String token) {
		log.info("JWTTokenProvider :: isTokenExpired");
		return extractExpiration(token).before(new Date());
	}

	/**
	 * STEP - 15 - 11
	 */
	public Date extractExpiration(String token) {
		log.info("JWTTokenProvider :: extractExpiration");
		return extractClaim(token, Claims::getExpiration);
	}
	
	/**
	 * STEP - 15 - 12
	 */
	 public UserDetails userDetails(String emailId){
	        return userInfoRepo
	                .findByEmailId(emailId)
	                .map(UserDetailObject::create)
	                .orElseThrow(()-> new UsernameNotFoundException("UserEmail: "+emailId+" does not exist"));
	    }
	
	 
	 // Get UserName from JWT token , ver inmportant step to getUserName and code and decode
	 public String getUserName(String token) {
		Claims claims =   Jwts.parserBuilder()
				 .setSigningKey(getSignKey())
				 .build()
				 .parseClaimsJws(token)
				 .getBody();
		  String userName = claims.getSubject();
		  return userName;
	 }

}
