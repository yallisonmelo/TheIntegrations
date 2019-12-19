package com.yfsmsystem.theintegrations.execptions.advices;

import com.yfsmsystem.theintegrations.execptions.UsuarioNotFoundException;
import com.yfsmsystem.theintegrations.response.Error;
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
        error.setType(ex.getMessage());
        error.setType("Usuario não encontrado");
        return error;
    }
}
