package com.alaa.school.controller;

import com.alaa.school.domain.Student;
import com.alaa.school.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService service) {
        this.studentService = service;
    }

    @GetMapping("/{studentId}")
    public Student getClassInSchool(@PathVariable Long studentId) {
        return studentService.getClassInSchool(studentId);
    }

    @GetMapping("/export-to-excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Student_Information.xlsx";
        response.setHeader(headerKey, headerValue);
        studentService.exportStudentToExcel(response);
    }

    @PostMapping("/{classId}")
    public Student addStudent(@RequestBody Student student, @PathVariable Long classId
    ) {
        return studentService.addStudent(student, classId);
    }
}

