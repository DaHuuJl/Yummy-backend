package com.yummy.restful.serveces;

import com.yummy.restful.dto.request.UserRequestAuthorizationDTO;
import com.yummy.restful.dto.request.UserRequestRegistrationDTO;
import com.yummy.restful.dto.response.UserResponseAuthorizationDTO;

public interface UserService {

    UserResponseAuthorizationDTO login (UserRequestAuthorizationDTO user);
    UserResponseAuthorizationDTO registration(UserRequestRegistrationDTO userDTO);
}