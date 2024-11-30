package com.curdapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curdapp.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}
