package com.alaa.school.controller;

import com.alaa.school.domain.Session;
import com.alaa.school.service.SessionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
   @PostMapping
    public Session addSessionToSchool(@RequestBody Session session){
        return sessionService.addSessionToSchool(session);
   }
}

