package com.yummy.restful.util.mappers;

import com.yummy.restful.dto.general.UserDTO;
import com.yummy.restful.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "fullName", target = "fullName"),
            @Mapping(source = "phoneNumber", target = "phoneNumber"),
            @Mapping(source = "image", target = "image"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "orders", ignore = true)
    })
    User toUser(UserDTO userDTO);

    @InheritInverseConfiguration
    UserDTO toUserDTO(User user);
}