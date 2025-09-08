package com.aishwarya.productservicesept.controllers;

import com.aishwarya.productservicesept.dtos.ProductRequestDTO;
import com.aishwarya.productservicesept.models.Product;
import com.aishwarya.productservicesept.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // this is the class which is the entry point of request
    // Get product details
    // Get all products
    // Create product
    // Update product
    // Delete product

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") String productId) {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductRequestDTO requestDTO) {
        return productService.createProduct(
                requestDTO.getTitle(),
                requestDTO.getDescription(),
                requestDTO.getPrice(),
                requestDTO.getCategory(),
                requestDTO.getImage()
        );
    }
    
}
