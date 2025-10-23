package com.aishwarya.productservicesept.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Product extends BaseModel  {
    private String title;
    private String description;
    private double price;
    // Transient Exception:
    // You cannot create a product without creating a category
    // We can use Cacade
    // PERSIST to
    // @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //@ManyToOne
            //(cascade = CascadeType.ALL)
    @ManyToOne
    private Category category;
    private String image;
}
