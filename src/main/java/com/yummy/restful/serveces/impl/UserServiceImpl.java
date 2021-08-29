package com.yummy.restful.serveces.impl;

import com.yummy.restful.dto.request.UserRequestAuthorizationDTO;
import com.yummy.restful.dto.request.UserRequestRegistrationDTO;
import com.yummy.restful.dto.response.UserResponseAuthorizationDTO;
import com.yummy.restful.model.User;
import com.yummy.restful.repository.UserRepository;
import com.yummy.restful.serveces.UserService;
import com.yummy.restful.util.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JWT javaWebToken;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JWT javaWebToken) {
        this.userRepository = userRepository;
        this.javaWebToken = javaWebToken;
    }

    @Override
    public UserResponseAuthorizationDTO login(UserRequestAuthorizationDTO user) {


        if(true) {
            UserResponseAuthorizationDTO dto = new UserResponseAuthorizationDTO();
            return dto;
        } else
            return null;
    }

    @Override
    public UserResponseAuthorizationDTO registration(UserRequestRegistrationDTO userDTO) {
        User user = new User(userDTO.getPassword(), userDTO.getFullName(), userDTO.getPhoneNumber());

        User chekUser = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (chekUser != null) {
            return null;
        }
        User newUser = userRepository.save(user);
        UserResponseAuthorizationDTO dto = new UserResponseAuthorizationDTO(javaWebToken.createToken(newUser));
        return dto;

    }
}