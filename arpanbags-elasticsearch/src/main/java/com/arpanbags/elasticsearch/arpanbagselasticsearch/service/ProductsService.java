package com.arpanbags.elasticsearch.arpanbagselasticsearch.service;


import com.arpanbags.elasticsearch.arpanbagselasticsearch.entity.Products;
import com.arpanbags.elasticsearch.arpanbagselasticsearch.repository.ProductsRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    public Iterable<Products> getAllProducts(){
      return  productsRepository.findAll();
    }

    public Products getProductById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    public Products createProduct(Products product) {
        return productsRepository.save(product);
    }

    public Products updateProduct(Long id, Products product) {
        if (productsRepository.existsById(id)) {
            product.setProductType(product.getProductType()); // Assuming setId() method is available to set the ID
            product.setProductName(product.getProductName());
            return productsRepository.save(product);
        } else {
            return null; // Handle case where product with given ID doesn't exist
        }
    }

    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

    public List<String> getListOfProductNames(String jsonResponse) {
        List<String> listOfProductNames = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            JsonNode sourceNode = jsonNode.get("_source");
            if (Objects.nonNull(sourceNode)) {
                JsonNode sourceJsonNode = objectMapper.readTree(sourceNode.asText());
                // Extract productName field
                String productName = sourceJsonNode.get("productName").asText();
                // Add productName to the list
                listOfProductNames.add(productName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfProductNames;
    }

    public  List<String> extractProductNames(String response) {
        List<String> productNames = new ArrayList<>();
        Pattern pattern = Pattern.compile("productName=([^,]+)");
        Matcher matcher = pattern.matcher(response);

        while (matcher.find()) {
            productNames.add(matcher.group(1));
        }

        return productNames;
    }
}




