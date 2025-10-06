package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.models.Category;
import com.aishwarya.productservicesept.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(String id) throws ProductNotFoundException;

    Product createProduct(String title,
                          String description,
                          double price,
                          Category category,
                          String image);

    List<Product> getAllProducts();

    void deleteProduct(Long id) throws ProductNotFoundException;
}
