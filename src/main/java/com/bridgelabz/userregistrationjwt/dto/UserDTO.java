package com.bridgelabz.userregistrationjwt.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@ToString
public class UserDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "First Name is Invalid!, Please Enter Valid First Name.")
    @NotEmpty(message = "First Name cannot be Empty")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "Last Name is Invalid!, Please Enter Valid Last Name.")
    @NotEmpty(message = "Last Name cannot be Empty")
    public String lastName;

    @Pattern(regexp ="^[a-z0-9]{1,}[.]{0,1}[a-zA-Z0-9]{0,}+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.]{0,1}[a-zA-Z]{0,2}$"
            ,message = "Email Address is Invalid!, Please Enter Valid Email Address.")
    @NotEmpty(message = "Email Address cannot be Empty")
    public String email;

    @Pattern(regexp = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@\\-#$%^&+=])" + "(?=\\S+$).{8,}$",
    message = "Password is Invalid!, Please Enter Valid Password.")
    @NotEmpty(message = "Password cannot be Empty")
    public String password;
}
