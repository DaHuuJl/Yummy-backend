package com.yummy.restful.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "order_details")
@NoArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orders", nullable = false)
    private Order order;
}