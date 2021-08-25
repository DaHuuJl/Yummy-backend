package com.yummy.restful.util.mappers;

import com.yummy.restful.dto.general.OrderDetailsDTO;
import com.yummy.restful.model.OrderDetails;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderDetailsMapper {

    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);

    @Mappings({

    })
    OrderDetails toOrderDetails(OrderDetailsDTO orderDetailsDTO);

    @InheritInverseConfiguration
    OrderDetailsDTO toOrderDetailsDTO(OrderDetails orderDetails);
}