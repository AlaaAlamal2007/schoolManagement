package com.alaa.school.service;

import com.alaa.school.domain.Teacher;
import com.alaa.school.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher addTeacher(Teacher teacher) {
        Teacher teacherAdded = new Teacher();
        teacherAdded.setFirstName(teacher.getFirstName());
        teacherAdded.setSecondName(teacher.getSecondName());
        teacherAdded.setThirdName(teacher.getThirdName());
        teacherAdded.setLastName(teacher.getLastName());
        teacherAdded.setIdentificationNumber(teacher.getIdentificationNumber());
        teacherAdded.setEmail(teacher.getEmail());
        teacherAdded.setMobile(teacher.getMobile());
        teacherAdded.setBirthDate(teacher.getBirthDate());
        teacherAdded.setGender(teacher.getGender());
        teacherAdded.setAddress(teacher.getAddress());
        return teacherRepository.save(teacherAdded);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}

