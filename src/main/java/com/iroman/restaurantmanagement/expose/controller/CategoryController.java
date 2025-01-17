package com.iroman.restaurantmanagement.expose.controller;

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Lombok annotations
@RequiredArgsConstructor

// Spring Stereotype annotation
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategorySmallDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public CategoryDto create(@RequestBody CategoryBodyDto categoryBody) {
        return categoryService.create(categoryBody);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable("id") Long id, @RequestBody CategoryBodyDto categoryBody) {
        return categoryService.update(id, categoryBody);
    }

    @DeleteMapping("/{id}")
    public CategoryDto disable(@PathVariable("id") Long id) {
        return categoryService.disable(id);
    }
}
