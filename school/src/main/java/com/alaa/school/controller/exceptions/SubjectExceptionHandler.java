package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.SubjectArgumentException;
import com.alaa.school.exceptions.SubjectResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SubjectExceptionHandler {
    @ResponseBody
    @ExceptionHandler({SubjectResourceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage subjectResourceHandler(SubjectResourceException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({SubjectArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage subjectArgumentHandler(SubjectArgumentException exception) {
        return new ErrorMessage(exception.getMessage());
    }
}


