package com.aishwarya.productservicesept.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
//    @OneToMany(mappedBy = "category")
//    private List<Product> expectedProducts;
}
