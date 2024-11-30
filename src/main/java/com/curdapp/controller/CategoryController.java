package com.curdapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curdapp.Dto.CategoryDTO;
import com.curdapp.entity.Category;
import com.curdapp.service.CategoryService;

@RestController
@RequestMapping("/apis/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategorieById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public String addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@RequestBody Category category,@PathVariable int id){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }
    
}
