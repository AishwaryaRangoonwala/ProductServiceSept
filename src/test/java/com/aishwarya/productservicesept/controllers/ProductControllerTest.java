package com.aishwarya.productservicesept.controllers;

import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.models.Product;
import com.aishwarya.productservicesept.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;

    @Test
    void testGetSingleProduct() throws ProductNotFoundException {
        System.out.println("Came in testGetSingleProduct");
        // AAA framework
        // A -> Arrange (Arrange input characters
        Long productId = 10L;
        Product expectedProduct = new Product(); // this is the
        // product object that service class is returning
        when(productService.getSingleProduct(String.valueOf(productId)))
                .thenReturn(expectedProduct);
        // A -> Act (Call the method which we want to test)
        // Controller is expected to return the same product object
        // what our service returned
        Product  actualProduct = productController.getSingleProduct(String.valueOf(productId));
        // A -> Assert
        assertEquals(expectedProduct, actualProduct);

    }

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