package com.alaa.school.service;

import com.alaa.school.domain.ClassInSchool;
import com.alaa.school.exceptions.ClassInSchoolResourceException;
import com.alaa.school.repository.ClassInSchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassInSchoolService {
    private final ClassInSchoolRepository classInSchoolRepo;

    public ClassInSchoolService(ClassInSchoolRepository classInSchoolRepository) {
        this.classInSchoolRepo = classInSchoolRepository;
    }

    public ClassInSchool getClassInSchool(Long classId) {
        return classInSchoolRepo.findById(classId).orElseThrow(
                () -> new ClassInSchoolResourceException("class does not exist" + classId)
        );
    }
}

