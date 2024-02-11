package com.alaa.school.domain;

import java.io.Serializable;
import java.util.Objects;

public class DailySessionDistributedPkId implements Serializable {
    private Long teacherId;
    private Long subjectId;
    private Long classId;
    private Long sessionId;

    public DailySessionDistributedPkId() {
    }

    public DailySessionDistributedPkId(Long teacherId, Long subjectId, Long classId, Long sessionId) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.classId = classId;
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailySessionDistributedPkId that = (DailySessionDistributedPkId) o;
        return Objects.equals(teacherId, that.teacherId) && Objects.equals(subjectId, that.subjectId) && Objects.equals(classId, that.classId) && Objects.equals(sessionId, that.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, subjectId, classId, sessionId);
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
}

