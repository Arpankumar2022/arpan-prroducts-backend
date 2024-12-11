package com.arpanbags.products.arpanbagsproducts.service;


import com.arpanbags.products.arpanbagsproducts.dto.ProductsTypeDTO;
import com.arpanbags.products.arpanbagsproducts.entity.ProductsType;
import com.arpanbags.products.arpanbagsproducts.mapper.ProductsTypeMapper;
import com.arpanbags.products.arpanbagsproducts.mapper.RestaurantMapper;
import com.arpanbags.products.arpanbagsproducts.repository.ProductsTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductTypeService {

    private final ProductsTypeRepository productsTypeRepository;

    public List<ProductsTypeDTO> getAllProductTypes() {
        return productsTypeRepository.findAll().stream().map(productsType ->
                        ProductsTypeMapper.INSTANCE.mapProductsTypeToProductsTypeDTO(productsType))
                .collect(Collectors.toList());
    }

    public ProductsTypeDTO getProductTypeById(Long id) {
        Optional<ProductsType> optionalProductType = productsTypeRepository.findById(id);
        // return optionalProductType.orElseThrow(() -> new RuntimeException("ProductType not found with id: " + id));
        if (optionalProductType.isPresent()) {
            return ProductsTypeMapper.INSTANCE.mapProductsTypeToProductsTypeDTO(optionalProductType.get());
        } else {
            throw new RuntimeException("ProductType not found with id: " + id);
        }
    }

    public ProductsTypeDTO createProductType(ProductsTypeDTO productsTypeDTO) {
        ProductsType savedProductsType = productsTypeRepository.save(ProductsTypeMapper
                .INSTANCE.mapProductsTypeDTOToProductsType(productsTypeDTO));
        return ProductsTypeMapper.INSTANCE.mapProductsTypeToProductsTypeDTO(savedProductsType);
    }

    public ProductsTypeDTO updateProductType(ProductsTypeDTO productsTypeDTO) {
        Optional<ProductsType> optionalProductsType = productsTypeRepository.findById(productsTypeDTO.getId());
        if(optionalProductsType.isPresent()){
            ProductsType productsType = optionalProductsType.get();
            productsType.setProductType(productsTypeDTO.getProductType());
            productsType.setProductName(productsTypeDTO.getProductName());
            productsTypeRepository.save(productsType);
            return ProductsTypeMapper.INSTANCE.mapProductsTypeToProductsTypeDTO(productsType);
        }else{
            throw new RuntimeException("ProductType not found with id: " + productsTypeDTO.getId());
        }
    }

    public void deleteProductType(Long id) {
        if (!productsTypeRepository.existsById(id)) {
            throw new RuntimeException("ProductType not found with id: " + id);
        }
        productsTypeRepository.deleteById(id);
    }


    public ProductsTypeDTO getProductTypeByProductName(String productName) {
      return ProductsTypeMapper.INSTANCE
              .mapProductsTypeToProductsTypeDTO(productsTypeRepository
                      .findByProductName(productName).get());

    }
}
