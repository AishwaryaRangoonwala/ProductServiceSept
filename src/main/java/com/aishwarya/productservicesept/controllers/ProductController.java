package com.aishwarya.productservicesept.controllers;

import com.aishwarya.productservicesept.dtos.ProductNotFoundErrorDTO;
import com.aishwarya.productservicesept.dtos.ProductRequestDTO;
import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.models.Product;
import com.aishwarya.productservicesept.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    // this is the class which is the entry point of request
    // Get product details
    // Get all products
    // Create product
    // Update product
    // Delete product

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") String productId) throws ProductNotFoundException {
        // call the service layer
        Product product = productService.getSingleProduct(productId);
        if (product == null) {
            throw new ProductNotFoundException("product with id " + productId + " not found.");
        }
        else {
             return product;
        }
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductRequestDTO requestDTO) throws ProductNotFoundException {

        return productService.createProduct(
                requestDTO.getTitle(),
                requestDTO.getDescription(),
                requestDTO.getPrice(),
                requestDTO.getCategory(),
                requestDTO.getImage()
        );
    }
    
}
