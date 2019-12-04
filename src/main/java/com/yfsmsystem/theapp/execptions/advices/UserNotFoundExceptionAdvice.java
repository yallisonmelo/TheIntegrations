package com.yfsmsystem.theapp.execptions.advices;

import com.yfsmsystem.theapp.execptions.UsuarioNotFoundException;
import com.yfsmsystem.theapp.response.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserNotFoundExceptionAdvice {

    @ExceptionHandler(UsuarioNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Error userNotFoundHandler(UsuarioNotFoundException ex) {
        Error error = new Error();
        error.setCode(HttpStatus.NOT_FOUND.toString());
        error.setDescription(ex.getMessage());
        error.setType("UserNotFoundException");
        return error;
    }
}
