package com.yummy.restful.util.mappers;

import com.yummy.restful.dto.general.OrderDTO;
import com.yummy.restful.model.Order;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mappings({

    })
    Order toOrder(OrderDTO orderDTO);

    @InheritInverseConfiguration
    OrderDTO toOrderDTO(Order order);
}