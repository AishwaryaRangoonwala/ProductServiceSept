package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.models.Category;
import com.aishwarya.productservicesept.models.Product;
import com.aishwarya.productservicesept.repositories.CategoryRepository;
import com.aishwarya.productservicesept.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getSingleProduct(String id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(Long.getLong(id));
        if (optionalProduct.isEmpty()) throw   new ProductNotFoundException("product not found");
        return optionalProduct.get();
    }

    @Override
    public Product createProduct(String title, String description, double price, Category category, String image) {
        Product p = new Product();
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImage(image);

        //first we should save the category
        if (category.getId() != null) {
            Optional<Category> categoryOptional = categoryRepository.findById(category.getId());

            if (categoryOptional.isEmpty()) {
                //throw InvalidCategoryException or create the category.
            }

            p.setCategory(categoryOptional.get());
        } else {
            Optional<Category> categoryOptional = categoryRepository.findByName(category.getName());

            if (categoryOptional.isPresent()) {
                p.setCategory(categoryOptional.get());
            } else {
                Category c = new Category();
                c.setName(category.getName());
                c = categoryRepository.save(c);

                p.setCategory(c);
            }
        }
//        // This categoryName exists in the table OR
//        Optional<Category> categoryOptional = categoryRepository.findByNameIgnoreCase(categoryName);
//        if (categoryOptional.isPresent()) {
//            product.setCategory(categoryOptional.get());
//        }
//        else {
//            Category newCategory = new Category();
//            newCategory.setName(categoryName);
//            Category savedCategory = categoryRepository.save(newCategory);
//            product.setCategory(savedCategory);
//        }
//        // This categoryName does not exists in the table
//        product.setImage(image);
        return productRepository.save(p);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) throw  new ProductNotFoundException("product not found");
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize) {
        /*
        PageSize = 10
        Page Number = 7
        Limit = 10
        Offset = 61
        Formula = (PageNumber - 1) * PageSize
         */
        Sort sort = Sort.by(Sort.Direction.ASC, "price")
                .and(Sort.by(Sort.Direction.DESC, "title"))
                .and(Sort.by(Sort.Direction.ASC, "id"));
        // .and is used when two products have the same price
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,sort);

        return productRepository.findByTitleContainsIgnoreCase(title, pageRequest);
    }
}
