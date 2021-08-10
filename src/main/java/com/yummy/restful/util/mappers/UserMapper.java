package com.yummy.restful.util.mappers;

import com.yummy.restful.dto.general.ProductDTO;
import com.yummy.restful.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}