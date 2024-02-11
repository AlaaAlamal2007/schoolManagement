package com.alaa.school.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "students")
public class Student extends AbstractPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "class_id")
    private Long classId;

    public Student(String firstName, String secondName, String thirdName, String lastName, Long identificationNumber, String email, String mobile, Instant birthDate, Gender gender, Address address,
                   Long id, Long classId) {
        super(firstName, secondName, thirdName, lastName, identificationNumber, email, mobile, birthDate, gender, address);
        this.id = id;
        this.classId = classId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Student() {

    }
}


