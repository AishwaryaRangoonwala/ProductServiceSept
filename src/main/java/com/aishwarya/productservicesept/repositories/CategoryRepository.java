package com.aishwarya.productservicesept.repositories;

import com.aishwarya.productservicesept.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /*
    JPA method - behind the scenes, implementation will
    be done by JPA on your behalf
     */
    Optional<Category> findByNameIgnoreCase(String name);

    Optional<Category> findByName(String name);
}
