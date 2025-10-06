package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.exceptions.CategoryNotFoundException;
import com.aishwarya.productservicesept.models.Category;
import com.aishwarya.productservicesept.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SelfCategoryService implements CategoryService {

    private CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteCategory(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isEmpty()) throw new CategoryNotFoundException("Category with id " + categoryId + " not found");
        categoryRepository.deleteById(categoryId);
    }
}
