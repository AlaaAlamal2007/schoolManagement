package com.alaa.school.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "teacher_subject")
@IdClass(TeacherSubjectPkId.class)
public class TeacherSubject implements Serializable {
    //    @EmbeddedId
//    private TeacherSubjectPkId teacherSubjectPkId;
    @Id
    private Long teacherId;
    @Id
    private Long subjectId;
    private Integer NumberTakenClass;
//    @OneToMany(mappedBy = "teacherSubject")
//    private Set<ClassInSchool> classInSchoolSet;

    public TeacherSubject() {
    }

    public TeacherSubject(Long teacherId, Long subjectId, Integer numberTakenClass
    ) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        NumberTakenClass = numberTakenClass;

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

    public Integer getNumberTakenClass() {
        return NumberTakenClass;
    }

    public void setNumberTakenClass(Integer numberTakenClass) {
        NumberTakenClass = numberTakenClass;
    }

    @Override
    public String toString() {
        return "TeacherSubject{" +
                "teacherId=" + teacherId +
                ", subjectId=" + subjectId +
                ", NumberTakenClass=" + NumberTakenClass +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherSubject that = (TeacherSubject) o;
        return Objects.equals(teacherId, that.teacherId) && Objects.equals(subjectId, that.subjectId) && Objects.equals(NumberTakenClass, that.NumberTakenClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, subjectId, NumberTakenClass);
    }
}


