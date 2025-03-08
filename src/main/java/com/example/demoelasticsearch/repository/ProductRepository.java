package com.example.demoelasticsearch.repository;

import com.example.demoelasticsearch.entity.Product;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findByName(String name);

    List<Product> findByDescription(String description);
}
