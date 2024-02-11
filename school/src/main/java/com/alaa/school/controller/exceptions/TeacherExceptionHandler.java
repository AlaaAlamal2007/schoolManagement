package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.TeacherArgumentException;
import com.alaa.school.exceptions.TeacherResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TeacherExceptionHandler {
    @ResponseBody
    @ExceptionHandler({TeacherResourceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage teacherResourceHandler(TeacherResourceException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler({TeacherArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage teacherArgumentHandler(TeacherArgumentException exception) {
        return new ErrorMessage(exception.getMessage());
    }
}




