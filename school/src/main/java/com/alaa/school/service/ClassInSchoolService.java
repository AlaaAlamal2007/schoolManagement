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

    public String addClassToSchool(ClassInSchool classInSchool) {
        ClassInSchool classAddedToSchool = new ClassInSchool();
        List<ClassInSchool> classInSchoolList = classInSchoolRepo.findAll();
        classAddedToSchool.setClassType(classInSchool.getClassType());
        classAddedToSchool.setClassNumber(classInSchool.getClassNumber());
        boolean existClass = false;
        for (ClassInSchool c : classInSchoolList) {
            if (c.getClassType() == classAddedToSchool.getClassType() &&
                    c.getClassNumber() == classAddedToSchool.getClassNumber()) {
                existClass = true;
                return "exist class";
            }
        }
        return classInSchoolRepo.save(classAddedToSchool) + "added";
    }
}




