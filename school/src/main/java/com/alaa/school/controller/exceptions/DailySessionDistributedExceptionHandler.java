package com.alaa.school.controller.exceptions;

import com.alaa.school.exceptions.DailySessionDistributedArgumentException;
import com.alaa.school.exceptions.DailySessionDistributedResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DailySessionDistributedExceptionHandler {
    @ResponseBody
    @ExceptionHandler(DailySessionDistributedResourceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage dailySessionDistributedResourceHandler(DailySessionDistributedResourceException e) {
        return new ErrorMessage(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(DailySessionDistributedArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage dailySessionDistributedArgumentHandler(DailySessionDistributedArgumentException e) {
        return new ErrorMessage(e.getMessage());
    }
}

