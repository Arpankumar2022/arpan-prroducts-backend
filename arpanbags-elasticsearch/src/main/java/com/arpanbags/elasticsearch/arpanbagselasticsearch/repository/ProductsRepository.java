package com.arpanbags.elasticsearch.arpanbagselasticsearch.repository;

import com.arpanbags.elasticsearch.arpanbagselasticsearch.entity.Products;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductsRepository extends ElasticsearchRepository<Products,Long> {
}
