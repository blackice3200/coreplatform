package com.commestack.coreplatform.exceptions;

import com.commestack.coreplatform.objects.models.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        CustomErrorResponse customErrorResponse=new CustomErrorResponse();
        customErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        customErrorResponse.setMessage(e.getMessage());
        customErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
    }

    //catch all Exceptions
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleAllException(Exception e) {
        CustomErrorResponse customErrorResponse=new CustomErrorResponse();
        customErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        customErrorResponse.setMessage(e.getMessage());
        customErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(customErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
