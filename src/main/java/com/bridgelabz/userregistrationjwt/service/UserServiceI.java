package com.bridgelabz.userregistrationjwt.service;

import com.bridgelabz.userregistrationjwt.dto.UserDTO;
import com.bridgelabz.userregistrationjwt.model.UserData;

import java.util.List;

public interface UserServiceI {

    List<UserData> getUserInfo();

    UserData addUser(UserDTO userDTO);

    UserData updateUserInfo(int userId, UserDTO userDTO);

    void deleteUserInfo(int userId);
}
