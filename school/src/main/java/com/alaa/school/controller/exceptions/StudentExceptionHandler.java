package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.StudentArgumentException;
import com.alaa.school.exceptions.StudentResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentExceptionHandler {
    @ResponseBody
    @ExceptionHandler({StudentResourceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage studentResourceHandler(StudentResourceException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({StudentArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage studentArgumentHandler(StudentArgumentException exception) {
        return new ErrorMessage(exception.getMessage());
    }
}

