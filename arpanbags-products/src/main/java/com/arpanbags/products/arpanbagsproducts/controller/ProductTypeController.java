package com.arpanbags.products.arpanbagsproducts.controller;


import com.arpanbags.products.arpanbagsproducts.dto.ProductsTypeDTO;
import com.arpanbags.products.arpanbagsproducts.entity.ProductsType;
import com.arpanbags.products.arpanbagsproducts.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    @GetMapping
    public ResponseEntity<List<ProductsTypeDTO>> getAllProducts() {
        System.out.println("This is getAllProducts coimg from ProductTypeController");
        List<ProductsTypeDTO> products = productTypeService.getAllProductTypes();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsTypeDTO> getProductById(@PathVariable Long id) {
        System.out.println("This is getProductById in ProductTypeController ");
        ProductsTypeDTO product = productTypeService.getProductTypeById(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping
    public ResponseEntity<ProductsTypeDTO> createProduct(@RequestBody ProductsTypeDTO productTypeDTO) {
        System.out.println("create product in ProductTypeController ");
        ProductsTypeDTO createdProduct = productTypeService.createProductType(productTypeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
    @PutMapping
    public ResponseEntity<ProductsTypeDTO> updateProduct( @RequestBody ProductsTypeDTO productsTypeDTO) {
        System.out.println("This is updateProduct in ProdcvutTypeContoller ");
        ProductsTypeDTO updatedProductsTypeDTO = productTypeService.updateProductType(productsTypeDTO);
        return ResponseEntity.ok(updatedProductsTypeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        System.out.println("Delete the product by Id ,ProductTypeController ");
        productTypeService.deleteProductType(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getProductByProductName/{productName}")
    public ResponseEntity<ProductsTypeDTO> getProductByProductName(@PathVariable String productName) {
        System.out.println("Get Products By Product Name in ProductTypeController");
        ProductsTypeDTO product = productTypeService.getProductTypeByProductName(productName);
        return ResponseEntity.ok(product);
    }

}
