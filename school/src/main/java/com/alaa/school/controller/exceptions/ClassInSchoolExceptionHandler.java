package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.ClassInSchoolArgumentException;
import com.alaa.school.exceptions.ClassInSchoolResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClassInSchoolExceptionHandler {
    @ResponseBody
    @ExceptionHandler({ClassInSchoolResourceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage classInSchoolResourceHandler(ClassInSchoolResourceException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({ClassInSchoolArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage ClassInSchoolArgumentHandler(ClassInSchoolArgumentException exception) {
        return new ErrorMessage(exception.getMessage());
    }
}



