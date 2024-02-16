package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.TeacherSubjectArgumentException;
import com.alaa.school.exceptions.TeacherSubjectResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TeacherSubjectExceptionHandler {
    @ResponseBody
    @ExceptionHandler({TeacherSubjectResourceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage teacherSubjectResourceHandler(TeacherSubjectResourceException e){
        return new ErrorMessage(e.getMessage());
    }
    @ResponseBody
    @ExceptionHandler({TeacherSubjectArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage teacherSubjectArgumentHandler(TeacherSubjectArgumentException e){
        return new ErrorMessage(e.getMessage());
    }
}


