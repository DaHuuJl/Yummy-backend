package com.yummy.restful.serveces.impl;

import com.yummy.restful.dto.general.ImageDTO;
import com.yummy.restful.dto.general.UserDTO;
import com.yummy.restful.dto.request.*;
import com.yummy.restful.dto.general.LoginHistoryDTO;
import com.yummy.restful.dto.response.UserResponseAuthorizationDTO;
import com.yummy.restful.model.LoginHistory;
import com.yummy.restful.model.User;
import com.yummy.restful.repository.LoginHistoryRepository;
import com.yummy.restful.repository.UserRepository;
import com.yummy.restful.serveces.UserService;
import com.yummy.restful.util.BrowserParse;
import com.yummy.restful.util.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LoginHistoryRepository loginHistoryRepository;
    private final BrowserParse browserParse = new BrowserParse();

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LoginHistoryRepository loginHistoryRepository) {
        this.userRepository = userRepository;
        this.loginHistoryRepository = loginHistoryRepository;
    }

    @Override
    public UserResponseAuthorizationDTO login(UserRequestAuthorizationDTO user) {
        final User chekUser = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(chekUser.getPassword().equals(user.getPassword())) {
            saveLoginHistory(user.getBrowser(), chekUser.getId());
            return new UserResponseAuthorizationDTO(chekUser.getId().toString());
        } else
            return null;
    }

    @Override
    public UserResponseAuthorizationDTO registration(UserRequestRegistrationDTO userDTO) {
        final User user = new User(userDTO.getPassword(), userDTO.getFullName(), userDTO.getPhoneNumber());
        User chekUser = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (chekUser != null) {
            return null;
        }
        final User newUser = userRepository.save(user);
        saveLoginHistory(userDTO.getBrowser(), newUser.getId());
        return new UserResponseAuthorizationDTO(user.getId().toString());
    }

    @Override
    public UserDTO getUserInfo(UserResponseAuthorizationDTO token) {
        final User user = userRepository.findById(Long.parseLong(token.getToken()));
        if (user != null)
            return UserMapper.INSTANCE.toUserDTO(user);
        else
            return null;
    }

    @Override
    public boolean changePhoneNumber(PhoneNumberDTO dto) {
        final User user = userRepository.findById(Long.parseLong(dto.getToken()));
        if(userRepository.findByPhoneNumber(dto.getPhoneNumber()) != null || user == null) {
            return false;
        }
        else {
            user.setPhoneNumber(dto.getPhoneNumber());
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public boolean changeFullName(FullNameDTO dto) {
        final User user = userRepository.findById(Long.parseLong(dto.getToken()));
        if (user == null)
            return false;
        else {
            user.setFullName(dto.getFullName());
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public boolean changePassword(PasswordsDTO dto) {
        final User user = userRepository.findById(Long.parseLong(dto.getToken()));
        if (user == null || !Objects.equals(user.getPassword(), dto.getOldPassword()))
            return false;
        else {
            user.setPassword(dto.getNewPassword());
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public boolean changeFile(ImageDTO dto) {
        final User user = userRepository.findById(Long.parseLong(dto.getToken()));
        if (user != null) {
            user.setImage(dto.getImage());
            userRepository.save(user);
            return true;
        } else
            return false;
    }

    @Override
    public void saveLoginHistory(String browser, long id) {
        final LoginHistory history = new LoginHistory();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy H:m");
        history.setUser(id);
        history.setBrowser(browserParse.parse(browser));
        history.setDate(df.format(new Date()));
        loginHistoryRepository.save(history);
    }

    @Override
    public List<LoginHistoryDTO> getLoginHistory(UserResponseAuthorizationDTO token) {
        final List<LoginHistory> history = loginHistoryRepository.findAllByUser(Long.parseLong(token.getToken()));
        List<LoginHistoryDTO> historyDTO = new ArrayList<>();
        for(int i = history.size()-1; i >= 0; i--) {
            historyDTO.add(new LoginHistoryDTO(history.get(i).getBrowser(), history.get(i).getDate()));
        }
        return historyDTO;
    }
}