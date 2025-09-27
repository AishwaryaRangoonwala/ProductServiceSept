package com.aishwarya.productservicesept.dtos;

import com.aishwarya.productservicesept.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private String description;
    private Category category;
    private Double price;
    private String image;
}
