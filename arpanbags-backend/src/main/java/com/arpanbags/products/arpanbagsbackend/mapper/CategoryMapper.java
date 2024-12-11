package com.arpanbags.products.arpanbagsbackend.mapper;

import org.springframework.stereotype.Component;

import com.arpanbags.products.arpanbagsbackend.dto.CategoryDTO;
import com.arpanbags.products.arpanbagsbackend.entity.Category;


@Component
public class CategoryMapper {
	
	
	/**
	 * Mapping to CategoryDTO from category Entity
	 * 
	 * @param category
	 * @return  CategoryDTO
	 */
	public static CategoryDTO mapToCategoryDTO(final Category category) {	
		return new CategoryDTO(category.getCategoryId(),
				category.getCategoryType(), 
				category.getCategoryName(),
				category.getProducts());
	}
	
	/**
	 * Mapping to Category Entity from CategoryDTO
	 * 
	 * @param categoryDTO
	 * @return  Category
	 */
	
	public static Category mapToCategoryEntity(final CategoryDTO categoryDTO) {
		return new Category(categoryDTO.getCategoryId(),
				categoryDTO.getCategoryType(),
				categoryDTO.getCategoryName(),
				categoryDTO.getListOfProducts());
	}
	
	

}
