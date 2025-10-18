package com.aishwarya.productservicesept.controllers;

import com.aishwarya.productservicesept.commons.AuthCommon;
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
    private AuthCommon authCommon;

    public ProductController(@Qualifier("selfProductService") ProductService productService, AuthCommon authCommon) {
        this.productService = productService;
        this.authCommon = authCommon;
    }

    // this is the class which is the entry point of request
    // Get product details
    // Get all products
    // Create product
    // Update product
    // Delete product

    @GetMapping("/{productId}/{tokenValue}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") String productId,
                                    @PathVariable("tokenValue") String tokenValue)
            throws ProductNotFoundException {
        if (!authCommon.validateToken(tokenValue)) {
            // Invalid Token
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        System.out.println("Passed authorization---------------->");
        // call the service layer
        Product product = productService.getSingleProduct(productId);
        if (product == null) {
            throw new ProductNotFoundException("product with id " + productId + " not found.");
        }
        else {
             return new ResponseEntity<>(product, HttpStatus.OK);
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

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) throws ProductNotFoundException {

    }
    
}
