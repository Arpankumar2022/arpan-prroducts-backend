package com.arpanbags.products.arpanbagsbackend.service;

import java.util.List;

import com.arpanbags.products.arpanbagsbackend.dto.ProductsDTO;
import com.arpanbags.products.arpanbagsbackend.entity.Products;

public interface ProductService {
	
	ProductsDTO createProducts(final ProductsDTO productsDTO);
	
	ProductsDTO updateProducts(final ProductsDTO productsDTO);
	
	List<ProductsDTO>  getAllProducts();
	
	Products getProduct(final Long productId);
	
	

}
