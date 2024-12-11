package com.arpanbags.products.arpanbagsbackend.dto;

import java.time.Instant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {
	
    
	
	private Long productId;
	
	@NotEmpty
	@Size(min = 2, message = "productName should have at least 2 characters")
	private String productName;
	
	@NotNull
	@Size(max = 50, message = "productDescription should have 50 characters")
	private String productDescription;
	
	@NotEmpty
	private Double productPrice;
	
	@NotEmpty
	private Long categoryId;
	
	private Instant createdDate;
	
	@NotNull
	@Size(max = 50, message = "mobile Number should have 10 characters")
	private String mobileNumber;

}
