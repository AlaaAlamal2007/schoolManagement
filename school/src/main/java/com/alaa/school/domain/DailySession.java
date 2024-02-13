package com.alaa.school.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "daily_sessions")
public class DailySession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SessionDay dayName;
    @Transient
    Set<DailySessionDistributed> dailySessionsInSchool;

    public DailySession() {
    }

    public DailySession(Long id, SessionDay dayName, Set<DailySessionDistributed> dailySessionsInSchool) {
        this.id = id;
        this.dayName = dayName;
        this.dailySessionsInSchool = dailySessionsInSchool;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SessionDay getDayName() {
        return dayName;
    }

    public void setDayName(SessionDay dayName) {
        this.dayName = dayName;
    }

    public Set<DailySessionDistributed> getDailySessionsInSchool() {
        return dailySessionsInSchool;
    }

    public void setDailySessionsInSchool(Set<DailySessionDistributed> dailySessionsInSchool) {
        this.dailySessionsInSchool = dailySessionsInSchool;
    }
}

