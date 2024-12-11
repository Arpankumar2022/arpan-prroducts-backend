package com.arpanbags.products.arpanbagsbackend.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_desc")
	private String productDescription;
	
	@Column(name="product_price")
	private Double productPrice;
	
	@ManyToOne
	@JoinColumn(name="category_id" , nullable=false)
	private Category category;
	
	@Column(name="created_date")
	private Instant createdDate;
	
	@Column(name="mob_num")
	private String mobileNumber;
	
	
	

}
