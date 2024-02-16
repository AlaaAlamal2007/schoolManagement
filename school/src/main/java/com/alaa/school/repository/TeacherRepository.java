package com.alaa.school.repository;

import com.alaa.school.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("From Teacher tch where tch.identificationNumber=:identificationNumberParameter")
    Optional<Teacher> findByIdentificationNumber(Long identificationNumberParameter);
}


