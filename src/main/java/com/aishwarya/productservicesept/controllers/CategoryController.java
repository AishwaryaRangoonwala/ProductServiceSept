package com.aishwarya.productservicesept.controllers;

import com.aishwarya.productservicesept.exceptions.CategoryNotFoundException;
import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.services.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) throws CategoryNotFoundException {
        categoryService.deleteCategory(categoryId);
    }
}
