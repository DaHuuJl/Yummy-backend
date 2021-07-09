package com.yummy.restful.util.mappers;

import com.yummy.restful.dto.general.ProductDTO;
import com.yummy.restful.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price_1", target = "price_1"),
            @Mapping(source = "price_2", target = "price_2"),
            @Mapping(source = "productType", target = "productType"),
            @Mapping(target = "id", ignore = true)
    })
    Product toProduct(ProductDTO productDTO);

    @InheritInverseConfiguration
    ProductDTO toProductDTO(Product product);
}