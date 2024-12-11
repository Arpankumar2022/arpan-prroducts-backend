package com.arpanbags.elasticsearch.arpanbagselasticsearch.util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import java.util.function.Supplier;

public class ElasticSearchUtils {


    /**
     * This method is basically  analogous to localhost:9200/_search  API
     * method having bod
     * {
     * "query": {
     * "match_all": {}
     * }
     * }
     * <p>
     * +++++++++++++++++++++++++
     * This method is created to equivalent java class in spring boot
     * We need to create matchAllQuery so that ElasticSearch will provide the Query
     * This matchAllQuery will help to return ElasticSearch Query for matchAllQuery
     * this will return new builder
     *
     * @return
     */
    public static MatchAllQuery matchAllQuery() {
        var matchAllQuery = new MatchAllQuery.Builder();
        return matchAllQuery.build();
    }

    /**
     * This matchAllQuery will be passed to ElasticSearch to matchRecords we are not sure so
     * we will create one Supplier method , which is used to Query Supplier which is used to
     * supply the Query to elastic search.
     */

    public static Supplier<Query> supplier() {
        Supplier<Query> supplier = () -> Query.of(q -> q.matchAll(matchAllQuery()));
        return supplier;
    }

    /**
     * When it is required to do query based upon an attribute name from the index
     * in that case we will use some other Supplier which  will not matchAllQuery rather
     * matchQuery to perform single attribute name matches with the request body.
     */
    public static MatchQuery matchQueryForAttributeName(String attributeValue) {
        var matchAQuery = new MatchQuery.Builder();
        return matchAQuery.field("productName").query(attributeValue).build();
    }

    /**
     * Supplier will be changed also as per matchQuery in above case
     */
    public static Supplier<Query> supplierQueryForAttributeName(String attributeValue) {
        Supplier<Query> supplier = () -> Query.of(q -> q.match(matchQueryForAttributeName(attributeValue)));
        return supplier;
    }

    /**
     * Creating method for AutoSuggest Match Query in ElasticSearch for angular Application
     *
     *
     */
    public static MatchQuery createAutoSuggestMatchQuery(String partialProductName){
        var autoSuggestQuery = new MatchQuery.Builder();
        return autoSuggestQuery.field("productName").query(partialProductName)
                .analyzer("standard").build();
    }
    /**
     * Now above MatchQuer will be wrap into Supplier which interacts with ElasticSearch
     */
    public static Supplier<Query>  createAutoSuggestMatchQuerySupplier(String partialProductName){
        Supplier<Query> supplier = ()-> Query.of(q-> q.match(createAutoSuggestMatchQuery(partialProductName)));
        return supplier;

    }

}
