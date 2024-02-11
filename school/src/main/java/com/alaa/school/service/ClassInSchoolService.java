package com.alaa.school.service;

import com.alaa.school.domain.ClassInSchool;
import com.alaa.school.domain.Student;
import com.alaa.school.exceptions.ClassInSchoolResourceException;
import com.alaa.school.repository.ClassInSchoolRepository;
import com.alaa.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ClassInSchoolService {
    private final ClassInSchoolRepository classInSchoolRepo;
    private final StudentRepository studentRepository;

    public ClassInSchoolService(ClassInSchoolRepository classInSchoolRepository, StudentRepository studentRepository) {
        this.classInSchoolRepo = classInSchoolRepository;
        this.studentRepository = studentRepository;
    }

    public ClassInSchool getClassInSchool(Long classId) {
        ClassInSchool classInSchool = classInSchoolRepo.findById(classId).orElseThrow(
                () -> new ClassInSchoolResourceException("class does not exist" + classId)
        );
        List<Student> students = studentRepository.findAllByClassId(classId);
        classInSchool.setStudents(new HashSet<>(students));
        return classInSchool;
    }

    public ClassInSchool addClassToSchool(ClassInSchool classInSchool) {
        ClassInSchool classAddedToSchool = new ClassInSchool();
        classAddedToSchool.setClassType(classInSchool.getClassType());
        classAddedToSchool.setClassNumber(classInSchool.getClassNumber());
        return classInSchoolRepo.save(classAddedToSchool);
    }
}



