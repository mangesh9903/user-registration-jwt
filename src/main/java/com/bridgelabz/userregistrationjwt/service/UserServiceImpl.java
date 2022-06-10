package com.bridgelabz.userregistrationjwt.service;

import com.bridgelabz.userregistrationjwt.dto.UserDTO;
import com.bridgelabz.userregistrationjwt.model.UserData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI{

    List<UserData> userDataList = new ArrayList<>();

    @Override
    public List<UserData> getUserInfo() {
        return userDataList;
    }

    @Override
    public UserData addUser(UserDTO userDTO) {
      UserData userData = null;
      userData = new UserData(userDTO);
      userDataList.add(userData);
      return userData;
    }

    @Override
    public UserData updateUserInfo(int userId, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUserInfo(int userId) {

    }
}
