package com.aishwarya.productservicesept.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String title;
    private String description;
    private String category;
    private Double price;
    private String image;
}
