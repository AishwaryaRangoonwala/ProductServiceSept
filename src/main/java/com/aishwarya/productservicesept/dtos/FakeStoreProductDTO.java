package com.aishwarya.productservicesept.dtos;

import com.aishwarya.productservicesept.models.Category;
import com.aishwarya.productservicesept.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private int id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;

    public Product toProduct() {

        Product product = new Product();
        product.setId(String.valueOf(this.id));
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImage(this.image);

        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);
        return product;
    }
}
