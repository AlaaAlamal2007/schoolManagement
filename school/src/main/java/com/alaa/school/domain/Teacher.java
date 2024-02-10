package com.alaa.school.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends AbstractPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Transient
    private Set<Subject> subjectSet;

    public Teacher(String firstName, String secondName, String thirdName,
                   String lastName, Long identificationNumber, String email,
                   String mobile, Instant birthDate, Gender gender, Address address,
                   Long id, Set<Subject> subjectSet) {
        super(firstName, secondName, thirdName, lastName, identificationNumber,
                email, mobile, birthDate, gender, address);
        this.id = id;
        this.subjectSet = subjectSet;
    }
    public Teacher(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }
}
