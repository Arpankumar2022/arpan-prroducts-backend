package com.arpanbags.products.arpanbagsbackend.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//https://www.udemy.com/course/full-stack-java-development-with-spring-boot-react/learn/lecture/38208676#overview
/**
 * STEP-2 part 1 - TO create userInfo Entity and Roles Entity 
 * and then respectively create repository of all 
 * 
 * 
 * @author Arpan Kumar
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER_INFO")
public class UserInfo {
	
	static
	{
		System.out.println("Entity class is loaded ::");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="email_Id" , nullable=false , unique=true)
	private String emailId;
	
	
	@Column(name = "password" , nullable = false)
	private String password;
	
	@Column(name = "mob_num")
	private String mobileNum;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="users_roles", 
	  joinColumns = @JoinColumn(name="user_id" , referencedColumnName = "id") , 
	  inverseJoinColumns =  {@JoinColumn(name="role_Id" , referencedColumnName = "id")} , uniqueConstraints = {
				@UniqueConstraint(columnNames = { "user_id", "role_id" }) } )
	private Set<Role> roles;   //it is possible for a user who has multiple ROLES ,   [ROLE_MANAGER , ROLE_ADMIN , ROLE_USER , ROLE_CUSTOMER 

}
