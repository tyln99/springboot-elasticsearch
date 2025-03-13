package com.example.demoelasticsearch.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    @Field(type = FieldType.Keyword, analyzer = "standard")
    private String name;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String description;
    private double price;
    private List<Comment> comments;

    @Data
    static class Comment {
        @Field(type = FieldType.Keyword, analyzer = "standard")
        private String user;
        @Field(type = FieldType.Text, analyzer = "standard")
        private String comment;
    }

}
