package com.yummy.restful.util.mappers;

import com.yummy.restful.dto.general.ProductDTOForOrder;
import com.yummy.restful.model.Product;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapperForOrder {

    ProductMapperForOrder INSTANCE = Mappers.getMapper(ProductMapperForOrder.class);

    @Mappings({
            @Mapping(source = "id", target = "id")
    })
    Product toProduct(ProductDTOForOrder productDTOForOrder);

    @InheritInverseConfiguration
    ProductDTOForOrder toProductDTOForOrder(Product product);
}