package com.yummy.restful.api;

import com.yummy.restful.dto.general.ImageDTO;
import com.yummy.restful.dto.general.UserDTO;
import com.yummy.restful.dto.request.*;
import com.yummy.restful.dto.general.LoginHistoryDTO;
import com.yummy.restful.dto.response.UserResponseAuthorizationDTO;
import com.yummy.restful.serveces.impl.UserServiceImpl;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseAuthorizationDTO> registration(@RequestBody UserRequestRegistrationDTO user) {
        final UserResponseAuthorizationDTO token = userServiceImpl.registration(user);
        return token != null
                ? new ResponseEntity<>(token, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseAuthorizationDTO> authorization(@RequestBody UserRequestAuthorizationDTO user) {
        final UserResponseAuthorizationDTO token = userServiceImpl.login(user);
        return token != null
                ? new ResponseEntity<>(token, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/getLoginHistory", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LoginHistoryDTO>> getLoginHistory(@RequestBody UserResponseAuthorizationDTO token) {
        final List<LoginHistoryDTO> history = userServiceImpl.getLoginHistory(token);
        return history != null
                ? new ResponseEntity<>(history, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserInfo(@RequestBody UserResponseAuthorizationDTO token) {
        final UserDTO userDTO = userServiceImpl.getUserInfo(token);
        return userDTO != null
                ? new ResponseEntity<>(userDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @RequestMapping(value = "/changeImage", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changeImage(@RequestBody ImageDTO dto) {
        return userServiceImpl.changeFile(dto)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/changePhoneNumber", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changePhoneNumber(@RequestBody PhoneNumberDTO dto) {
        return userServiceImpl.changePhoneNumber(dto)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/changeFullName", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changeFullName(@RequestBody FullNameDTO dto) {
        return userServiceImpl.changeFullName(dto)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changePassword(@RequestBody PasswordsDTO dto) {
        return userServiceImpl.changePassword(dto)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}