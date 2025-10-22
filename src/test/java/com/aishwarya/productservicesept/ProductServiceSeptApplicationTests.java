package com.aishwarya.productservicesept;

import com.aishwarya.productservicesept.models.Category;
import com.aishwarya.productservicesept.models.Product;
import com.aishwarya.productservicesept.repositories.CategoryRepository;
import com.aishwarya.productservicesept.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceSeptApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void testFetchTypes() {
//        Optional<Product> optionalProduct = productRepository.findById(1L);
//        System.out.println("DEBUG");
//        Optional<Category> optionalCategory = categoryRepository.findById(1L);
//        List<Product> products = optionalCategory.get().getExpectedProducts();
//        System.out.println("DEBUG");
//    }

}
