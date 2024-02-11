package com.alaa.school.domain;

import jakarta.persistence.*;

import java.time.Instant;

@MappedSuperclass
public abstract class AbstractPerson {
    private String firstName;
    private String secondName;
    private String thirdName;
    private String lastName;
    private Long identificationNumber;
    private String email;
    private String mobile;
    private Instant birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public AbstractPerson(String firstName, String secondName, String thirdName, String lastName, Long identificationNumber, String email, String mobile, Instant birthDate,
                          Gender gender, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.mobile = mobile;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AbstractPerson() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}


