package com.pos.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.pos.backend.entity.Category;
import com.pos.backend.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category getCategoryByCategoryName(String categryName) {
        return categoryRepository.findByCategoryName(categryName).orElse(null);
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getItemCategoryId()).orElse(null);
        if (existingCategory == null) {
            return null;
        }

        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());

        return categoryRepository.save(existingCategory);

    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
