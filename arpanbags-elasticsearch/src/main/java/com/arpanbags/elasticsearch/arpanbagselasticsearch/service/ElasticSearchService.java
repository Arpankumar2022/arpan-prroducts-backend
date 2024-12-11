package com.arpanbags.elasticsearch.arpanbagselasticsearch.service;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.arpanbags.elasticsearch.arpanbagselasticsearch.util.ElasticSearchUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class ElasticSearchService {

    private final ElasticsearchClient elasticsearchClient;

    /**
     * To perform the ElasticSearch  with matchAll query in
     * <p>
     * localhost:9200/_search
     * {   "query": {
     * "match_all": {}
     * }
     * }
     *
     * @return
     * @throws IOException
     */
    public SearchResponse<Map> matchAllServices() throws IOException {
        Supplier<Query> supplier = ElasticSearchUtils.supplier();
        SearchResponse<Map> searchResponse =
                elasticsearchClient.search(s -> s.query(supplier.get()), Map.class);
        System.out.println("ElasticSearch query is : " + supplier.get().toString());
        return searchResponse;
    }

    /**
     * To perform the ElasticSearch  with matchAllIndexBased query in
     * localhost:9200/indexName/_search
     * <p>
     * {
     * "query": {
     * "match_all": {}
     * }
     * }
     *
     * @param indexName
     * @return
     * @throws IOException
     */
    public SearchResponse<Map> matchIndexBasedServices(String indexName) throws IOException {
        Supplier<Query> supplier = ElasticSearchUtils.supplier();
        SearchResponse<Map> searchResponse =
                elasticsearchClient.search(s -> s.index(indexName).query(supplier.get()), Map.class);
        System.out.println("ElasticSearch query is : " + supplier.get().toString());
        return searchResponse;
    }


    /**
     * To perform the Elastic search query match with any attribute name
     * {
     * "query": {
     * "match": {
     * "name": {
     * "query" : "mobile"
     * }
     * }
     * }
     * }
     * This is used to perform query from elastic search based upon attributes present in product index
     */

    public SearchResponse<Map> matchQueryForAttributeName(String attributeValue, String indexName) throws IOException {
        Supplier<Query> supplier = ElasticSearchUtils.supplierQueryForAttributeName(attributeValue);
        SearchResponse<Map> searchResponse =
                elasticsearchClient.search(s -> s.index(indexName).query(supplier.get()), Map.class);
        System.out.println("ElasticSearch query is : " + supplier.get().toString());
        return searchResponse;
    }
    /**
     *
     */
   public SearchResponse<Map>  createAutoSuggestMatchQuery(String partialProductName,String indexName) throws IOException {
       Supplier<Query> supplier = ElasticSearchUtils.createAutoSuggestMatchQuerySupplier(partialProductName);
       SearchResponse<Map> searchResponse =
               elasticsearchClient.search(s -> s.index(indexName).query(supplier.get()), Map.class);
       System.out.println("ElasticSearch query is : " + supplier.get().toString());
       return searchResponse;
   }

}
