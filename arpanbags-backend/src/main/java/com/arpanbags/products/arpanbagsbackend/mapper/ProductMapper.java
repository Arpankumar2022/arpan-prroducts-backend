package com.arpanbags.products.arpanbagsbackend.mapper;

import java.time.Instant;
import java.util.Optional;
import org.springframework.context.annotation.Configuration;
import com.arpanbags.products.arpanbagsbackend.dto.ProductsDTO;
import com.arpanbags.products.arpanbagsbackend.entity.Category;
import com.arpanbags.products.arpanbagsbackend.entity.Products;
import com.arpanbags.products.arpanbagsbackend.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class ProductMapper {
	
	private static CategoryRepository categoryRepository;
	
	
	/**
	 *  Mapping of Product to ProductDTO
	 * @param product
	 * @return ProductsDTO
	 */
	public static ProductsDTO mapToProductDTO(final Products product) {		
		log.info("ProductMapper mapToProductDTO() :: ");
		return new ProductsDTO(product.getProductId(),
				product.getProductName(),
				product.getProductDescription(),
				product.getProductPrice(),
				product.getCategory().getCategoryId(), 
				product.getCreatedDate(),
				product.getMobileNumber());			
	}
	
	/**
	 *  Mapping of ProductsDTO to Products	 *  
	 * @param productDTO
	 * @return Products
	 */
	public static Products mapToProductEntity(final ProductsDTO productDTO) {		
		Optional<Category> category = Optional.ofNullable(categoryRepository.findById(productDTO.getCategoryId())).orElseThrow();
		log.info("ProductMapper mapToProductEntity() :: ");
		return new Products(productDTO.getProductId(),
				productDTO.getProductName(),
				productDTO.getProductDescription(),
				productDTO.getProductPrice(),
				category.isPresent()?category.get(): null,
				Instant.now(),
				productDTO.getMobileNumber());			
	}

}
