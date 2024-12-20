package com.curdapp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curdapp.Dto.CategoryDTO;
import com.curdapp.entity.Category;
import com.curdapp.entity.Product;
import com.curdapp.repository.CategoryRepository;
import com.curdapp.repository.ProductRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    
    public Page<CategoryDTO> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(CategoryDTO::new); // Properly map each Category to CategoryDTO
    }
    

    public CategoryDTO getCategoryById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return new CategoryDTO(category);
    }
    
    public String addCategory(Category category){
        categoryRepository.save(category);
        return "Data Added Successfully";
    }

    public Category updateCategory(int id,Category category){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Data Not Found for Update"));
        existingCategory.setCategory_name(category.getCategory_name());
        existingCategory.setDescription(category.getDescription());
        categoryRepository.save(existingCategory);
        return existingCategory;
    }

    public void deleteCategory(int id){
        Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found"));

        productRepository.deleteAll(category.getProducts());
        categoryRepository.deleteById(id);
    }

    public Optional<Product> findById(int cid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
