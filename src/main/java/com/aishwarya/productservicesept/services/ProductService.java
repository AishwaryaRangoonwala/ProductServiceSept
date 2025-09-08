package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(String id);

    Product createProduct(String title,
                          String description,
                          double price,
                          String categoryName,
                          String image);

    List<Product> getAllProducts();
}
