package com.alaa.school.repository;

import com.alaa.school.domain.ClassInSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInSchoolRepository extends JpaRepository<ClassInSchool, Long> {
}



