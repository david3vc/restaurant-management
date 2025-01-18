package com.iroman.restaurantmanagement.application.service;

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySavedDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;

import java.util.List;

public interface CategoryService {
    List<CategorySmallDto> findAll();

    CategoryDto findById(Long id);

    CategorySavedDto create(CategoryBodyDto categoryBody);

    CategorySavedDto update(Long id, CategoryBodyDto categoryBody);

    CategorySavedDto disable(Long id);
}
