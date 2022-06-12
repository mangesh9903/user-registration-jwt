package com.bridgelabz.userregistrationjwt.controller;

import com.bridgelabz.userregistrationjwt.dto.ResponseDTO;
import com.bridgelabz.userregistrationjwt.dto.UserDTO;
import com.bridgelabz.userregistrationjwt.dto.UserLoginDTO;
import com.bridgelabz.userregistrationjwt.model.UserData;
import com.bridgelabz.userregistrationjwt.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***********************************************************************************************************************
 * Class : User Rest Controller Class
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@RequestMapping("/userregistration")
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    /**
     * Method :- Method for User Login.
     *
     * @param userLoginDTO :- passing userLoginDTO as Input
     * @return :- Returning Token.
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        log.info("inside userLogin Controller Method");
        ResponseDTO responseDTO = new ResponseDTO("User Logged In Successfully!!!",
                userServiceI.loginUser(userLoginDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method for User Registration.
     *
     * @param userDTO :- passing userDTO as Input
     * @return :- Returning UserData
     */
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        UserData userData = null;
        log.info("inside registerUser Controller Method");
        userData = userServiceI.registerUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Added Successfully.", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * Method :- Method to Get All User Records.
     *
     * @return :- Returning  All User Records Present in Database.
     */
    @GetMapping("/getUserInfo")
    public ResponseEntity<ResponseDTO> getUserInfo() {
        List<UserData> userDataList = null;
        userDataList = userServiceI.getUserInfo();
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info ", userDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method :- Method to Get  User Record By Passing User Id.
     *
     * @param userId :- passing userId as Input
     * @return :- Returning User Record Present in Database.
     */
    @GetMapping("/getUserInfoById/{userId}")
    public ResponseEntity<ResponseDTO> getUserInfoById(@PathVariable int userId) {
        UserData userData = null;
        userData = userServiceI.getUserInfoById(userId);
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info For Id :- ", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
