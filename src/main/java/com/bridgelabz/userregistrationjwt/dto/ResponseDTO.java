package com.bridgelabz.userregistrationjwt.dto;

import lombok.Data;
/***********************************************************************************************************************
 * Class : Response DTO Class.
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
