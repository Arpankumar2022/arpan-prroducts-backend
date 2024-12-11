package com.arpanbags.elasticsearch.arpanbagselasticsearch.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "products3")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {

    private Long id;
    private String productName;
    private String productType;


}
