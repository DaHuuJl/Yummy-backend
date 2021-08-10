package com.yummy.restful.util.mappers;

import com.yummy.restful.dto.general.ProductDTO;
import com.yummy.restful.model.Product;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price_1", target = "price_1"),
            @Mapping(source = "price_2", target = "price_2"),
            @Mapping(source = "productType", target = "productType"),
            @Mapping(source = "image", target = "image"),
            @Mapping(target = "orderDetailsList", ignore = true)
    })
    Product toProduct(ProductDTO productDTO);

    @InheritInverseConfiguration
    ProductDTO toProductDTO(Product product);
}