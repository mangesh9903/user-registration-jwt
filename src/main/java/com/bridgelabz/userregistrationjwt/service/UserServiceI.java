package com.bridgelabz.userregistrationjwt.service;

import com.bridgelabz.userregistrationjwt.dto.UserDTO;
import com.bridgelabz.userregistrationjwt.dto.UserLoginDTO;
import com.bridgelabz.userregistrationjwt.model.UserData;

import java.util.List;
/***********************************************************************************************************************
 * interface : User Service Interface.
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
public interface UserServiceI {


    String loginUser(UserLoginDTO userLoginDTO);

    UserData getUserInfoById(int userId);

    List<UserData> getUserInfo();

    UserData registerUser(UserDTO userDTO);


}
