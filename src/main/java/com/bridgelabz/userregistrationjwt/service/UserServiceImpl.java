package com.bridgelabz.userregistrationjwt.service;

import com.bridgelabz.userregistrationjwt.dto.UserDTO;
import com.bridgelabz.userregistrationjwt.dto.UserLoginDTO;
import com.bridgelabz.userregistrationjwt.exception.UserException;
import com.bridgelabz.userregistrationjwt.model.UserData;
import com.bridgelabz.userregistrationjwt.repository.UserRepository;
import com.bridgelabz.userregistrationjwt.utility.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

/***********************************************************************************************************************
 * Class : User Service Implementation Class.
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@Slf4j
@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public String loginUser(UserLoginDTO userLoginDTO) {
        UserData userData = null;
        userData = new UserData(userLoginDTO);
        String token = tokenUtil.createToken(userData.getUserId());
        log.info("LoginUser Service Method Successfully executed");
        String message = "Logged in Successfully!! Your token is : " + token;
        return message;

    }

    @Override
    public UserData getUserInfoById(int userId) {
        log.info("getUserInfoById Service Method Successfully executed");
        return userRepository.findById(userId).orElseThrow(() ->
                new UserException("User Id " + userId + " Not Found In the Database."));
    }

    @Override
    public List<UserData> getUserInfo() {
        log.info("getUserInfo Service Method Successfully executed");
        return userRepository.findAll();
    }

    @Override
    public UserData registerUser(UserDTO userDTO) {

        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        log.info("registerUser Service Method Successfully executed");
        UserData userData = null;
        userData = new UserData(userDTO);
        userRepository.save(userData);
        return userData;
    }
}
