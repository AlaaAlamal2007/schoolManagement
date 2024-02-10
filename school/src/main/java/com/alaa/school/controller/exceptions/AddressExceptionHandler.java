package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.AddressArgumentException;
import com.alaa.school.exceptions.AddressResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AddressExceptionHandler {
    @ResponseBody
    @ExceptionHandler({AddressResourceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage addressResourceHandler(AddressResourceException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({AddressArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage addressArgumentHandler(AddressArgumentException exception) {
        return new ErrorMessage(exception.getMessage());
    }
}


