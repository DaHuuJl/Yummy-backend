package com.yummy.restful.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy ="order",  fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetailsList;

    @ManyToOne
    @JoinColumn(name = "usr", nullable = false)
    private User user;
}