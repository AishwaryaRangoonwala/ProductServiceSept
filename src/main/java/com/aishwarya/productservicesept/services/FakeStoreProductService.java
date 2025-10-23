package com.aishwarya.productservicesept.services;

import com.aishwarya.productservicesept.dtos.FakeStoreProductDTO;
import com.aishwarya.productservicesept.exceptions.ProductNotFoundException;
import com.aishwarya.productservicesept.models.Category;
import com.aishwarya.productservicesept.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate<String, Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Product getSingleProduct(String id) throws ProductNotFoundException {
        // First check if the product exists in the redis
        // with the given id

        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCT_" + id);
        if (product != null) {
            return product;
        }
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
        Product p =  response.toProduct();
        // Before returning this product, store it in the redis
        redisTemplate.opsForHash().put("PRODUCTS", "PRODUCT_" + p.getId().toString(), p);
        return p;
    }

    @Override
    public Product createProduct(String title, String description, double price, Category category, String image) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setCategory(category.getName());
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

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {

    }

    @Override
    public Page<Product> getProductsByTitle(String title, int pageNumber, int pageSize) {
        return null;
    }
}
