package com.yummy.restful.serveces.impl;

import com.yummy.restful.dto.request.UserRequestRegistrationDTO;
import com.yummy.restful.model.User;
import com.yummy.restful.model.enums.UserStatus;
import com.yummy.restful.repository.UserRepository;
import com.yummy.restful.serveces.UserService;
import com.yummy.restful.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Converter converter;
    //private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Converter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
        //this.passwordEncoder = BCryptPasswordEncoder;
    }


    @Override
    public boolean registration(UserRequestRegistrationDTO userDTO) {
        User user = converter.userRequestRegistrationToEntity(userDTO);
        if(findByUsername(user.getUsername()) != null) {
            return false;
        } else {
            user.setStatus(UserStatus.ACTIVE);
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
