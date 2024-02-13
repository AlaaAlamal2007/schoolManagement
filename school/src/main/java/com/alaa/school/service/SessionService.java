package com.alaa.school.service;

import com.alaa.school.domain.Session;
import com.alaa.school.repository.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session addSessionToSchool(Session session) {
        return sessionRepository.save(session);
    }
}


