package com.example.BlogApplicationSpringboot.services.impl;
import com.example.BlogApplicationSpringboot.entities.Category;
import com.example.BlogApplicationSpringboot.exceptions.ResourceNotFoundException;
import com.example.BlogApplicationSpringboot.payloads.CategoryDto;
import com.example.BlogApplicationSpringboot.payloads.UserDto;
import com.example.BlogApplicationSpringboot.repositories.CategoryRepo;
import com.example.BlogApplicationSpringboot.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepo.save(category);
        return this.modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()
                -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCategory = this.categoryRepo.save(category);
      return  this.modelMapper.map(updatedCategory,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> allcategories = this.categoryRepo.findAll();
        List<CategoryDto> collectedCategories =
                allcategories.stream().map(category ->
                        modelMapper.map(category, CategoryDto.class))
                        .collect(Collectors.toList());
        return collectedCategories;
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()
                -> new ResourceNotFoundException("Category", "Category Id", categoryId));
       return this.modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        this.categoryRepo.delete(category);

    }
}
