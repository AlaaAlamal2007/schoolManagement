package com.alaa.school.domain;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;
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

    public Teacher() {
    }

    public Teacher(String firstName, String secondName,
                   String thirdName, String lastName, Long identificationNumber, String email, String mobile, Instant birthDate, Gender gender, Address address, Long id, Set<Subject> subjectSet) {
        super(firstName, secondName, thirdName, lastName, identificationNumber, email, mobile, birthDate, gender, address);
        this.id = id;
        this.subjectSet = subjectSet;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", subjectSet=" + subjectSet +
                '}';
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(subjectSet, teacher.subjectSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectSet);
    }
}




