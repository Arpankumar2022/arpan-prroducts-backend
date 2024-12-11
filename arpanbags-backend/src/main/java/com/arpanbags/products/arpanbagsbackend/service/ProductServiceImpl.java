package com.arpanbags.products.arpanbagsbackend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpanbags.products.arpanbagsbackend.dto.ProductsDTO;
import com.arpanbags.products.arpanbagsbackend.entity.Products;
import com.arpanbags.products.arpanbagsbackend.mapper.ProductMapper;
import com.arpanbags.products.arpanbagsbackend.repository.ProductsRepository;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductsRepository productRepository;
	
	

	@Override
	public ProductsDTO createProducts(ProductsDTO productsDTO) {
		Products savedProduct = productRepository.save(ProductMapper.mapToProductEntity(productsDTO));
		return ProductMapper.mapToProductDTO(savedProduct);
	}

	@Override
	public ProductsDTO updateProducts(ProductsDTO productsDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductsDTO> getAllProducts() {
		List<ProductsDTO> listProductsDTO = new ArrayList<>();
		List<Products> listOfProducts =  Optional.ofNullable(productRepository.findAll()).orElse(Collections.emptyList());
		if(!listOfProducts.isEmpty()) {
			listOfProducts.forEach(product -> {
				listProductsDTO.add(ProductMapper.mapToProductDTO(product));
			});
		}
		return listProductsDTO;
	}

	@Override
	public Products getProduct(Long productId) {
		return Optional.ofNullable(productRepository.findById(productId)).orElse(null).get();
	}

}
