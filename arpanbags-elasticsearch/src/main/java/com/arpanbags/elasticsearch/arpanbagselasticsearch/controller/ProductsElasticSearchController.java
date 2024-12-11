package com.arpanbags.elasticsearch.arpanbagselasticsearch.controller;


import com.elastic.clients.elasticsearch.core.SearchResponse;
import com.arpanbags.elasticsearch.arpanbagselasticsearch.entity.Products;
import com.arpanbags.elasticsearch.arpanbagselasticsearch.service.ElasticSearchService;
import com.arpanbags.elasticsearch.arpanbagselasticsearch.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/elastic-search/products")
@RequiredArgsConstructor
public class ProductsElasticSearchController {


    private final ProductsService productsService;

    private final ElasticSearchService elasticSearchService;

    @GetMapping
    public Iterable<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Long id) {
        return productsService.getProductById(id);
    }

    @PostMapping
    public Products createProduct(@RequestBody Products product) {
        return productsService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products product) {
        return productsService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }

    @GetMapping("/matchAll")
    public SearchResponse<Map> matchAll() throws IOException {
        return elasticSearchService.matchAllServices();
    }

    @GetMapping("/matchAllIndexBased/{indexName}")
    public String matchAll(@PathVariable String indexName) throws IOException {
        SearchResponse<Map> searchResponse = elasticSearchService.matchIndexBasedServices(indexName);
        System.out.println("ElasticSearch matchAll Based on Index : " + searchResponse.hits().hits().toString());
        return searchResponse.hits().hits().toString();
    }

    @GetMapping("/matchQueryForAttributeName/{indexName}/{attributeValue}")
    public String matchQueryForAttributeName(@PathVariable String indexName, @PathVariable String attributeValue) throws IOException {
        SearchResponse<Map> searchResponse = elasticSearchService.matchQueryForAttributeName(attributeValue, indexName);
        System.out.println("ElasticSearch matchAll Based on Index : " + searchResponse.hits().hits().toString());
        return searchResponse.hits().hits().toString();
    }

    @GetMapping("/createAutoSuggestMatchQuery/{indexName}/{attributeValue}")
    public List<String> createAutoSuggest(@PathVariable String indexName, @PathVariable String attributeValue) throws IOException {
        SearchResponse<Map> searchResponse = elasticSearchService.createAutoSuggestMatchQuery(attributeValue, indexName);
        System.out.println("ElasticSearch matchAll Based on Index : " + searchResponse.hits().hits().toString());
        String jsonResponse = searchResponse.hits().hits().toString();
        return productsService.extractProductNames(jsonResponse);
    }


}
