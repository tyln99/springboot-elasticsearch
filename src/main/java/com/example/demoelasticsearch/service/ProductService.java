package com.example.demoelasticsearch.service;

import com.example.demoelasticsearch.entity.Product;
import com.example.demoelasticsearch.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public void update(String id, Product input) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(input.getPrice());
            product.setDescription(input.getDescription());
            product.setName(input.getName());
            productRepository.save(product); // Overwrites the entire document
        }

    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByDescription(String description) {
        return productRepository.findByDescription(description);
    }

    public List<Product> findByUserComment(String user) {
        return productRepository.findByComments_user(user);
    }

    public List<Product> findByComment(String comment) {
        return productRepository.findByComments_comment(comment);
    }

    public List<Product> saveAll(List<Product> products) {
        return (List<Product>) productRepository.saveAll(products);
    }
}
