package com.aishwarya.productservicesept.controllers;

import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.models.Product;
import com.aishwarya.productservicesept.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;

//    @Test
//    void testGetSingleProduct() throws ProductNotFoundException {
//        System.out.println("Came in testGetSingleProduct");
//        // AAA framework
//        // A -> Arrange (Arrange input characters
//        Long productId = 2L;
//        Product expectedProduct = new Product(); // this is the
//        // product object that service class is returning
//        expectedProduct.setId(productId);
//        expectedProduct.setTitle("iPhone 17 pro");
//        expectedProduct.setDescription("iPhone 17 pro");
//        expectedProduct.setPrice(140000);
//        when(productService.getSingleProduct(String.valueOf(productId)))
//                .thenReturn(expectedProduct);
//        // A -> Act (Call the method which we want to test)
//        // Controller is expected to return the same product object
//        // what our service returned
//        ResponseEntity<Product>  actualProduct = productController.getSingleProduct(String.valueOf(productId), "test");
//        // A -> Assert
//        assertEquals(expectedProduct, actualProduct.getBody());
//
//    }

//    @Test
//    void testGetSingleProductWithProductNotFoundException() throws ProductNotFoundException {
//        System.out.println("Came in testGetSingleProductWithProductNotFoundException");
//        // A -> Arrange
//        String productId = "-1L";
//
//        when(productService.getSingleProduct(productId))
//                .thenThrow(ProductNotFoundException.class);
//
//
//        assertThrows(ProductNotFoundException.class,
//                () ->
//                productController.getSingleProduct(productId, "test"));
//    }

//    @Test
//    void testGetAllProducts() throws ProductNotFoundException {
//        System.out.println("Came in testGetAllProducts");
//        // A -> Arrange
//        List<Product> expectedProducts = new ArrayList<>();
//        Product p1 = new Product();
//        Product p2 = new Product();
//        Product p3 = new Product();
//
//        expectedProducts.add(p1);
//        expectedProducts.add(p2);
//        expectedProducts.add(p3);
//
//        when (productService.getAllProducts())
//                .thenReturn(expectedProducts);
//
//        List<Product> actualProducts = productController.getAllProducts();
//
//        assertEquals(expectedProducts, actualProducts);
//    }

    @Test
    void testSample() {
        int a = 10;
        int b = 15;

        int actualOutput = a+b;

        //Param-1: Expected Output
        //Param-2: Actual Output
        assertEquals(25, actualOutput);
    }

}

// Test Case is nothing but a method which tests
// a particular functionality and can
// get executed automatically