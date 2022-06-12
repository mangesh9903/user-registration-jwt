package com.bridgelabz.userregistrationjwt.exception;

import com.bridgelabz.userregistrationjwt.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
/***********************************************************************************************************************
 * Class : Global Exception Class.
 * @author : Mangesh
 * @since : 12-06-2022
 *
 **********************************************************************************************************************/
@ControllerAdvice
public class UserExceptionalHandler {
    private static final String MESSAGE = "Exception while processing REST Request";

    @ExceptionHandler
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(MESSAGE, errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(UserException exception) {
        ResponseDTO responseDTO = new ResponseDTO(MESSAGE, exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
