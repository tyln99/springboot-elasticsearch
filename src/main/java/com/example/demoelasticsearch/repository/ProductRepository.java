package com.example.demoelasticsearch.repository;

import com.example.demoelasticsearch.entity.Product;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findByName(String name);

//    @Query("{\"match\": {\"description\": {\"query\": \"?0\", \"fuzziness\": \"AUTO\"}}}")
    List<Product> findByDescription(String description);

    List<Product> findByComments_user(String user);

    List<Product> findByComments_comment(String comment);
}
