package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.dtos.FakeStoreProductDTO;
import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(String id) throws ProductNotFoundException {
        FakeStoreProductDTO response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class
        );
        if (response == null) {
            // Isn't null response an exception / unexpected
            // Should we throw an exception here
            // Should we handle custom exceptions?
            throw new ProductNotFoundException("Product with id " + id  + " not found! ");
        }
        // call the service layer
        return response.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, double price, String categoryName, String image) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setCategory(categoryName);
        fakeStoreProductDTO.setImage(image);
        FakeStoreProductDTO responseDTO = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDTO,
                FakeStoreProductDTO.class
                );
        return responseDTO.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        // https://fakestoreapi.com/products
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
            products.add(fakeStoreProductDTO.toProduct());
        }
        return products;
    }
}
