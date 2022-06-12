package com.bridgelabz.userregistrationjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
/***********************************************************************************************************************
 * Class : AppConif Class
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@Component
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
