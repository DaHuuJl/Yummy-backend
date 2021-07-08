package com.yummy.restful.util;

import com.yummy.restful.dto.request.UserRequestAuthorizationDTO;
import com.yummy.restful.dto.request.UserRequestRegistrationDTO;
import com.yummy.restful.model.User;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public User userRequestAuthorizationToEntity(UserRequestAuthorizationDTO userDTO) {
        final User user = new User();


        return user;
    }

    public User userRequestRegistrationToEntity(UserRequestRegistrationDTO  userDTO) {
        final User user = new User();


        return user;
    }


}
