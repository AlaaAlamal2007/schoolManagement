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

    public String addTeacher(Teacher teacher) {
        Teacher teacherExist = teacherRepository.findByIdentificationNumber(teacher.getIdentificationNumber()).orElse(null);

        if (teacherExist == null) {
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
            return teacherRepository.save(teacherAdded) + "added";
        }
        return "teacher exist";
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}


