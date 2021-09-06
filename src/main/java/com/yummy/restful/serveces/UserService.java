package com.yummy.restful.serveces;

import com.yummy.restful.dto.general.ImageDTO;
import com.yummy.restful.dto.general.LoginHistoryDTO;
import com.yummy.restful.dto.general.UserDTO;
import com.yummy.restful.dto.request.*;
import com.yummy.restful.dto.response.UserResponseAuthorizationDTO;

import java.util.List;

public interface UserService {

    List<LoginHistoryDTO> getLoginHistory(UserResponseAuthorizationDTO token);
    UserDTO getUserInfo(UserResponseAuthorizationDTO token);
    UserResponseAuthorizationDTO login (UserRequestAuthorizationDTO user);
    UserResponseAuthorizationDTO registration(UserRequestRegistrationDTO userDTO);
    void saveLoginHistory(String browser, long id);
    boolean changePhoneNumber(PhoneNumberDTO dto);
    boolean changeFullName(FullNameDTO dto);
    boolean changePassword(PasswordsDTO dto);
    boolean changeFile(ImageDTO dto);
}