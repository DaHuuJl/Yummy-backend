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
    //private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.passwordEncoder = BCryptPasswordEncoder;
    }


    @Override
    public boolean registration(UserRequestRegistrationDTO userDTO) {
        User user = new User();//converter.userRequestRegistrationToEntity(userDTO);
/*        if(findByUsername(user.getUsername()) != null) {
            return false;
        } else {
            //user.setStatus(UserStatus.ACTIVE);
            userRepository.save(user);
            return true;
        }*/
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}