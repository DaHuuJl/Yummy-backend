package com.yummy.restful.api;

import com.yummy.restful.dto.request.UserRequestAuthorizationDTO;
import com.yummy.restful.dto.request.UserRequestRegistrationDTO;
import com.yummy.restful.dto.response.UserResponseAuthorizationDTO;
import com.yummy.restful.serveces.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    //APPLICATION_JSON_UTF8_VALUE
    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseAuthorizationDTO> registration(@RequestBody UserRequestRegistrationDTO user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        UserResponseAuthorizationDTO token = userServiceImpl.registration(user);
        responseHeaders.add("token", String.valueOf(token));
        return token != null
                ? new ResponseEntity<>(token, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseAuthorizationDTO> authorization(@RequestBody UserRequestAuthorizationDTO user) {
        UserResponseAuthorizationDTO token = userServiceImpl.login(user);
        return token != null
                ? new ResponseEntity<>(token, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}