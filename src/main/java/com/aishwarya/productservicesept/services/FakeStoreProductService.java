package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.dtos.FakeStoreProductDTO;
import com.aishwarya.productservicesept.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(String id) {
        FakeStoreProductDTO response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class
        );
        // call the service layer
        return response.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, double price, String categoryName, String image) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
