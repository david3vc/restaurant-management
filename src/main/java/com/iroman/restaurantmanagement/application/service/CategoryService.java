package com.iroman.restaurantmanagement.application.service;

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;

import java.util.List;

public interface CategoryService {
    List<CategorySmallDto> findAll();

    CategoryDto findById(Long id);

    CategoryDto create(CategoryBodyDto categoryBody);

    CategoryDto update(Long id, CategoryBodyDto categoryBody);

    CategoryDto disable(Long id);
}
