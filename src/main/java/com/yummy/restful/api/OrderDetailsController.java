package com.yummy.restful.api;

import com.yummy.restful.serveces.impl.OrderDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/orderDetails",produces = {MediaType.APPLICATION_JSON_VALUE})
public class OrderDetailsController {

    private final OrderDetailsServiceImpl orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsServiceImpl orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }
}
