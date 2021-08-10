package com.yummy.restful.serveces.impl;

import com.yummy.restful.repository.OrderDetailsRepository;
import com.yummy.restful.serveces.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final OrderDetailsRepository orderDetails;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetails) {
        this.orderDetails = orderDetails;
    }
}
