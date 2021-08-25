package com.yummy.restful.dto.general;

import com.yummy.restful.model.enums.ProductType;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price_1;
    private Double price_2;
    private ProductType productType;
    private String image;
}