package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.exceptions.CategoryNotFoundException;

public interface CategoryService {
    void deleteCategory(Long categoryId) throws CategoryNotFoundException;
}
