package com.alaa.school.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "daily_sessions_distributed")
@IdClass(DailySessionDistributedPkId.class)
public class DailySessionDistributed implements Serializable {
    @Id
    @JoinColumn(name = "teacher_subject_teacher_id")
    private Long teacherSubjectTeacherId;
    @Id
    @JoinColumn(name = "teacher_subject_subject_id")
    private Long teacherSubjectSubjectId;
    @Id
    @JoinColumn(name = "class_id")
    private Long classId;
    @Id
    @JoinColumn(name = "session_id")
    private Long sessionId;
    @JoinColumn(name = "daily_sessions_id")
    private Long dailySessionsId;

    public DailySessionDistributed() {
    }

    public DailySessionDistributed(Long teacherSubjectTeacherId, Long teacherSubjectSubjectId, Long classId, Long sessionId, Long dailySessionsId
    ) {
        this.teacherSubjectTeacherId = teacherSubjectTeacherId;
        this.teacherSubjectSubjectId = teacherSubjectSubjectId;
        this.classId = classId;
        this.sessionId = sessionId;
        this.dailySessionsId = dailySessionsId;

    }

    public Long getTeacherSubjectTeacherId() {
        return teacherSubjectTeacherId;
    }

    public void setTeacherSubjectTeacherId(Long teacherSubjectTeacherId) {
        this.teacherSubjectTeacherId = teacherSubjectTeacherId;
    }

    public Long getTeacherSubjectSubjectId() {
        return teacherSubjectSubjectId;
    }

    public void setTeacherSubjectSubjectId(Long teacherSubjectSubjectId) {
        this.teacherSubjectSubjectId = teacherSubjectSubjectId;
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
        return Objects.equals(teacherSubjectTeacherId, that.teacherSubjectTeacherId) && Objects.equals(teacherSubjectSubjectId, that.teacherSubjectSubjectId) && Objects.equals(classId, that.classId) && Objects.equals(sessionId, that.sessionId) && Objects.equals(dailySessionsId, that.dailySessionsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherSubjectTeacherId, teacherSubjectSubjectId, classId, sessionId, dailySessionsId);
    }

    @Override
    public String toString() {
        return "DailySessionDistributed{" +
                "teacherId=" + teacherSubjectTeacherId +
                ", subjectId=" + teacherSubjectSubjectId +
                ", classId=" + classId +
                ", sessionId=" + sessionId +
                ", dailySessionsId=" + dailySessionsId +
                '}';
    }
}

