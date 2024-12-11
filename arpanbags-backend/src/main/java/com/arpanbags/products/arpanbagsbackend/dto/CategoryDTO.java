package com.arpanbags.products.arpanbagsbackend.dto;

import java.util.List;

import com.arpanbags.products.arpanbagsbackend.entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	
    private Long categoryId;
	private String categoryType;
	private String categoryName;
	private List<Products>  listOfProducts;

}
