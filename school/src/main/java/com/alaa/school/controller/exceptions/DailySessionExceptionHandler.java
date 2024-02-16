package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.DailySessionArgumentException;
import com.alaa.school.exceptions.DailySessionResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DailySessionExceptionHandler {
    @ResponseBody
    @ExceptionHandler({DailySessionResourceException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage dailySessionResourceHandler(DailySessionResourceException exception){
        return new ErrorMessage(exception.getMessage());
    }
    @ResponseBody
    @ExceptionHandler({DailySessionArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage dailySessionArgumentHandler(DailySessionArgumentException exception){
        return new ErrorMessage(exception.getMessage());
    }
}
