package com.bridgelabz.userregistrationjwt.model;

import com.bridgelabz.userregistrationjwt.dto.UserDTO;
import com.bridgelabz.userregistrationjwt.dto.UserLoginDTO;
import lombok.Data;

import javax.persistence.*;

/***********************************************************************************************************************
 * Class : User Model Class.
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@Data
@Entity
@Table(name = "User_Data")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")
    private int userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    public boolean verified;

    public UserData() {

    }

    public UserData(UserDTO userDTO) {
        this.firstName = userDTO.firstName;
        this.lastName = userDTO.lastName;
        this.email = userDTO.email;
        this.password = userDTO.password;
    }

    public UserData(UserLoginDTO userLoginDTO) {
        this.email = userLoginDTO.email;
        this.password = userLoginDTO.password;
    }
}
