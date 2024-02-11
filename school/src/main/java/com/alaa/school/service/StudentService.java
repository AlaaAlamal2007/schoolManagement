package com.alaa.school.service;

import com.alaa.school.utils.ExcelStudentExportUtils;
import com.alaa.school.domain.Student;
import com.alaa.school.exceptions.StudentResourceException;
import com.alaa.school.repository.StudentRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getClassInSchool(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(
                () -> new StudentResourceException("student does not exist " + studentId)
        );
    }

    public List<Student> exportStudentToExcel(HttpServletResponse response) throws IOException {
        List<Student> students = studentRepository.findAll();
        ExcelStudentExportUtils exportUtils = new ExcelStudentExportUtils(students);
        exportUtils.exportDataToExcel(response);
        return students;
    }

    public Student addStudent(Student student, Long classId) {
        Student studentAdd = new Student();
        studentAdd.setFirstName(student.getFirstName());
        studentAdd.setSecondName(student.getSecondName());
        studentAdd.setThirdName(student.getThirdName());
        studentAdd.setLastName(student.getLastName());
        studentAdd.setIdentificationNumber(student.getIdentificationNumber());
        studentAdd.setEmail(student.getEmail());
        studentAdd.setMobile(student.getMobile());
        studentAdd.setBirthDate(student.getBirthDate());
        studentAdd.setAddress(student.getAddress());
        studentAdd.setGender(student.getGender());
        studentAdd.setClassId(classId);
        return studentRepository.save(studentAdd);
    }
}


