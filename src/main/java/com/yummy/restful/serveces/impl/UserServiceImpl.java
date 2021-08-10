package com.yummy.restful.serveces.impl;

import com.yummy.restful.dto.request.UserRequestRegistrationDTO;
import com.yummy.restful.model.User;
import com.yummy.restful.repository.UserRepository;
import com.yummy.restful.serveces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public boolean registration(UserRequestRegistrationDTO userDTO) {

        return true;
    }
}