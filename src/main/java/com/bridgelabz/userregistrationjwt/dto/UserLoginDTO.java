package com.bridgelabz.userregistrationjwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
/***********************************************************************************************************************
 * Class : User Login DTO Class.
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserLoginDTO {

    @Pattern(regexp ="^[a-z0-9]{1,}[.]{0,1}[a-zA-Z0-9]{0,}+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.]{0,1}[a-zA-Z]{0,2}$"
            ,message = "Email Address is Invalid!, Please Enter Valid Email Address.")
    @NotEmpty(message = "Email Address cannot be Empty")
    public String email;

    @Pattern(regexp = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@\\-#$%^&+=])" + "(?=\\S+$).{8,}$",
            message = "Password is Invalid!, Please Enter Valid Password.")
    @NotEmpty(message = "Password cannot be Empty")
    public String password;

}
