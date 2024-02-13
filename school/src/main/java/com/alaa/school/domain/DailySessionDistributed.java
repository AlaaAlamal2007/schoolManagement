package com.alaa.school.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "daily_sessions_distributed")
@IdClass(DailySessionDistributedPkId.class)
public class DailySessionDistributed implements Serializable {
    @Id
    private Long teacherId;
    @Id
    private Long subjectId;
    @Id
    private Long classId;
    @Id
    private Long sessionId;
    @JoinColumn(name = "daily_sessions_id")
    private Long dailySessionsId;

    public DailySessionDistributed() {
    }

    public DailySessionDistributed(Long teacherId, Long subjectId, Long classId, Long sessionId, Long dailySessionsId) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.classId = classId;
        this.sessionId = sessionId;
        this.dailySessionsId = dailySessionsId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getDailySessionsId() {
        return dailySessionsId;
    }

    public void setDailySessionsId(Long dailySessionsId) {
        this.dailySessionsId = dailySessionsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailySessionDistributed that = (DailySessionDistributed) o;
        return Objects.equals(teacherId, that.teacherId) && Objects.equals(subjectId, that.subjectId) && Objects.equals(classId, that.classId) && Objects.equals(sessionId, that.sessionId) && Objects.equals(dailySessionsId, that.dailySessionsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, subjectId, classId, sessionId, dailySessionsId);
    }

    @Override
    public String toString() {
        return "DailySessionDistributed{" +
                "teacherId=" + teacherId +
                ", subjectId=" + subjectId +
                ", classId=" + classId +
                ", sessionId=" + sessionId +
                ", dailySessionsId=" + dailySessionsId +
                '}';
    }
}

