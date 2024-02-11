package com.alaa.school.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "classes")
public class ClassInSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "class_type")
    private ClassType classType;
    @Column(name = "class_number")
    private Integer classNumber;
    @Transient
    private Set<Student> students;

    public ClassInSchool() {
    }

    public ClassInSchool(ClassType classType, Integer classNumber, Set<Student> students) {
        this.classType = classType;
        this.classNumber = classNumber;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ClassInSchool{" +
                "id=" + id +
                ", classType=" + classType +
                ", classNumber=" + classNumber +
                ", students=" + students +
                '}';
    }
}


