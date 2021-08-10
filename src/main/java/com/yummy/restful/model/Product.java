package com.yummy.restful.model;

import com.yummy.restful.model.enums.ProductType;
import com.yummy.restful.repository.OrderRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price1")
    private Double price_1;

    @Column(name = "price2")
    private Double price_2;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType productType;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy ="product",  fetch = FetchType.LAZY)
    List<OrderDetails> orderDetailsList;
}