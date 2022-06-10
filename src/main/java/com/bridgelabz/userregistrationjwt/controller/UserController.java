package com.bridgelabz.userregistrationjwt.controller;

import com.bridgelabz.userregistrationjwt.dto.ResponseDTO;
import com.bridgelabz.userregistrationjwt.dto.UserDTO;
import com.bridgelabz.userregistrationjwt.model.UserData;
import com.bridgelabz.userregistrationjwt.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/userregistration")
@RestController
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    @GetMapping("/getUserInfo")
    public ResponseEntity<ResponseDTO> getUserInfo() {
        List<UserData> userDataList = null;
        userDataList = userServiceI.getUserInfo();
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info ", userDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addUserInfo")
    public ResponseEntity<ResponseDTO> addUserInfo(@Valid @RequestBody UserDTO userDTO) {
        UserData userData = null;
        userData = userServiceI.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Added Successfully.", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
}
