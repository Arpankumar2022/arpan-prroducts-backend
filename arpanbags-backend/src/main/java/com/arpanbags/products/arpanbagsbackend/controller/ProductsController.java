package com.arpanbags.products.arpanbagsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpanbags.products.arpanbagsbackend.dto.ProductsDTO;
import com.arpanbags.products.arpanbagsbackend.service.ProductService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value="/v1/api/products")
public class ProductsController {
	
	
	@Autowired
	private ProductService productService;
	
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')") // THIS IS BASED UPON @ENABLEMETHODSECURITY level security
	@PostMapping("/create-products")
	public ResponseEntity<ProductsDTO>  createProducts(@RequestBody ProductsDTO productsDTO){
		log.info("ProductsController createProducts() :: ");
		log.info("ProductsController createProducts() Objects:: "+productsDTO);
		ProductsDTO savedProduct = productService.createProducts(productsDTO);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAll-products")
	public ResponseEntity<List<ProductsDTO>>  getProductsList(){
		log.info("ProductsController getProductsList() :: ");
		List<ProductsDTO> listProductDTO = productService.getAllProducts();
		return   new ResponseEntity<>(listProductDTO, HttpStatus.OK);
	}
	
	
	

}
