package com.yummy.restful.serveces;

import com.yummy.restful.dto.request.UserRequestRegistrationDTO;
import com.yummy.restful.model.User;

public interface UserService {

    boolean registration(UserRequestRegistrationDTO userDTO);
}