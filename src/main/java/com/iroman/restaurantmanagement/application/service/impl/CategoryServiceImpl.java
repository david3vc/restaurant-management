package com.iroman.restaurantmanagement.application.service.impl;

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySavedDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.application.mapper.CategoryMapper;
import com.iroman.restaurantmanagement.application.service.CategoryService;
import com.iroman.restaurantmanagement.persistence.entity.Category;
import com.iroman.restaurantmanagement.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// Lombok annotation
@RequiredArgsConstructor

// Spring Stereotype annotation
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategorySmallDto> findAll() {
        return ((List<Category>) categoryRepository.findAll())
                .stream()
                .map(categoryMapper::toSmallDto)
                .toList();
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElse(null);
    }

    @Override
    public CategorySavedDto create(CategoryBodyDto categoryBody) {
        Category category = categoryMapper.toEntity(categoryBody);
        category.setState("A");
        category.setCreatedAt(LocalDateTime.now());

        return categoryMapper.toSavedSto(categoryRepository.save(category));
    }

    @Override
    public CategorySavedDto update(Long id, CategoryBodyDto categoryBody) {
        Category category = categoryRepository.findById(id).get();
        categoryMapper.updateEntity(category, categoryBody);
        category.setUpdatedAt(LocalDateTime.now());

        return categoryMapper.toSavedSto(categoryRepository.save(category));
    }

    @Override
    public CategorySavedDto disable(Long id) {
        Category category = categoryRepository.findById(id).get();
        category.setState("E");
        // category.setUpdatedAt(LocalDateTime.now());

        return categoryMapper.toSavedSto(categoryRepository.save(category));
    }
}
