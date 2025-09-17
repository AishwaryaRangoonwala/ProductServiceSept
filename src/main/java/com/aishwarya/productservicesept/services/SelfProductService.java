package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.models.Category;
import com.aishwarya.productservicesept.models.Product;
import com.aishwarya.productservicesept.repositories.CategoryRepository;
import com.aishwarya.productservicesept.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getSingleProduct(String id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, double price, String categoryName, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        // This categoryName exists in the table OR
        Optional<Category> categoryOptional = categoryRepository.findByNameIgnoreCase(categoryName);
        if (categoryOptional.isPresent()) {
            product.setCategory(categoryOptional.get());
        }
        else {
            Category newCategory = new Category();
            newCategory.setName(categoryName);
            Category savedCategory = categoryRepository.save(newCategory);
            product.setCategory(savedCategory);
        }
        // This categoryName does not exists in the table
        product.setImage(image);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
