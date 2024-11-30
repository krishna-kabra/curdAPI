package com.curdapp.Dto;

import java.util.List;
import java.util.stream.Collectors;

import com.curdapp.entity.Category;

import lombok.Data;

@Data
public class CategoryDTO {
    private int cid;
    private String category_name;
    private String description;
    private List<ProductDTO> products;

    // Constructor
    public CategoryDTO(Category category) {
        this.cid = category.getCid();
        this.category_name = category.getCategory_name();
        this.description = category.getDescription();
        this.products = category.getProducts()
                                .stream()
                                .map(ProductDTO::new)
                                .collect(Collectors.toList());
    }

    // Getters and Setters
}