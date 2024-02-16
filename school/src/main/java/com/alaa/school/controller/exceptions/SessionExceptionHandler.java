package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.SessionArgumentException;
import com.alaa.school.exceptions.SessionResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SessionExceptionHandler {
    @ResponseBody
    @ExceptionHandler({SessionResourceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage sessionResourceHandler(SessionResourceException exception){
        return new ErrorMessage(exception.getMessage());
    }
    @ResponseBody
    @ExceptionHandler({SessionArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage sessionArgumentHandler(SessionArgumentException exception){
        return new ErrorMessage(exception.getMessage());
    }
}

