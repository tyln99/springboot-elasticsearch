package com.example.demoelasticsearch.controller;

import com.example.demoelasticsearch.entity.Product;
import com.example.demoelasticsearch.service.ProductService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/bulk")
    public List<Product> createProducts(@RequestBody List<Product> products) {
        return productService.saveAll(products);
    }

    @GetMapping("/find-by-name")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productService.findByName(name);
    }

    @GetMapping("/search-by-description")
    public List<Product> searchProductsByDescription(@RequestParam String description) {
        return productService.findByDescription(description);
    }

    @GetMapping("/search-by-comment-user")
    public List<Product> searchProductsByCommentUser(@RequestParam String user) {
        return productService.findByUserComment(user);
    }

    @GetMapping("/search-by-comment")
    public List<Product> searchByComment(@RequestParam String comment) {
        return productService.findByComment(comment);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.delete(id);
    }

    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.findAll();
    }


}
