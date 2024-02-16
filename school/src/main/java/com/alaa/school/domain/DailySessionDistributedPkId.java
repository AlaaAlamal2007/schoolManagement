package com.alaa.school.domain;

import java.io.Serializable;
import java.util.Objects;

public class DailySessionDistributedPkId implements Serializable {
    private Long teacherSubjectTeacherId;
    private Long teacherSubjectSubjectId;
    private Long classId;

    private Long sessionId;

    public DailySessionDistributedPkId() {
    }

    public DailySessionDistributedPkId(Long teacherId, Long subjectId, Long classId, Long sessionId) {
        this.teacherSubjectTeacherId = teacherId;
        this.teacherSubjectSubjectId = subjectId;
        this.classId = classId;
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailySessionDistributedPkId that = (DailySessionDistributedPkId) o;
        return Objects.equals(teacherSubjectTeacherId, that.teacherSubjectTeacherId) && Objects.equals(teacherSubjectSubjectId, that.teacherSubjectSubjectId) && Objects.equals(classId, that.classId) && Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherSubjectTeacherId, teacherSubjectSubjectId, classId, sessionId);
    }

    public Long getTeacherId() {
        return teacherSubjectTeacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherSubjectTeacherId = teacherId;
    }

    public Long getSubjectId() {
        return teacherSubjectSubjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.teacherSubjectSubjectId = subjectId;
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
}


