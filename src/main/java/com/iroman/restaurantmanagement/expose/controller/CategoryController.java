package com.iroman.restaurantmanagement.expose.controller;

import com.iroman.restaurantmanagement.persistence.entity.Category;
import com.iroman.restaurantmanagement.persistence.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> findAll(){
        List<Category> categories = (List<Category>)categoryRepository.findAll();
        return categories;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long id){
        Category category = (Category)categoryRepository.findById(id).orElse(null);
        return category;
    }
}
