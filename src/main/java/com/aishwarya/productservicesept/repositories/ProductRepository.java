package com.aishwarya.productservicesept.repositories;

import com.aishwarya.productservicesept.models.Category;
import com.aishwarya.productservicesept.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Reference Doc: https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByTitle(String title);
    List<Product> findByTitleContainsIgnoreCase(String title);
    // List<Product> findByTitleContainsIgnoreCaseTop10(String title);
    List<Product> findByTitleIgnoreCaseAndDescriptionContainsIgnoreCase(String title, String description);

    // Category class and find by Name
    // select id from categories where name = name
    // select * from products where category_id = id
    List<Product> findByCategory_Name(String name);

    List<Product> findByCategory(Category category);
}
