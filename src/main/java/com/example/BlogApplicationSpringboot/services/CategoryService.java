package com.example.BlogApplicationSpringboot.services;

import com.example.BlogApplicationSpringboot.payloads.CategoryDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CategoryService {

    // create
     CategoryDto createCategory(CategoryDto categoryDto);

    // update
     CategoryDto updateCategory (CategoryDto categoryDto, Integer categoryId);

    // get all categories
     List<CategoryDto> getCategories();

    // get category By ID
     CategoryDto getCategory(Integer categoryId);

    // delete category
     void deleteCategory(Integer categoryId);

}
