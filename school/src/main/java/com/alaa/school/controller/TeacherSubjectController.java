package com.alaa.school.controller;

import com.alaa.school.domain.Subject;
import com.alaa.school.domain.Teacher;
import com.alaa.school.domain.TeacherSubject;
import com.alaa.school.repository.TeacherRepository;
import com.alaa.school.service.SubjectService;
import com.alaa.school.service.TeacherSubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/teacher-subject")
public class TeacherSubjectController {
    private final TeacherSubjectService teacherSubjectService;
    private final TeacherRepository teacherRepository;
    private final SubjectService subjectService;

    public TeacherSubjectController(TeacherSubjectService teacherSubjectService, TeacherRepository repository,
                                    SubjectService subjectService) {
        this.teacherSubjectService = teacherSubjectService;
        this.teacherRepository = repository;

        this.subjectService = subjectService;
    }

    @PostMapping
    public String assignTeacherToSubject(@RequestBody TeacherSubject teacherSubject) {
        return teacherSubjectService.assignTeacherToSubject(teacherSubject);
    }

    //give all teacher teaches this subject
    @GetMapping("/{subjectId}")
    public List<Teacher> getAllTeacherTeachesSubject(@PathVariable Long subjectId) {
        List<TeacherSubject> teacherSubjectList = teacherSubjectService.getAllTeacherTeachesSubject(subjectId);
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher = new Teacher();
        for (TeacherSubject t : teacherSubjectList) {
            teacher = teacherRepository.findById(t.getTeacherId()).orElseThrow(
                    () -> new RuntimeException("does not exist")
            );
            teachers.add(teacher);
        }
        return teachers;
    }

    /*
        getAllSubjectsTeachedByteacher

     */
    @GetMapping("/getSubjects/{teacherId}")
    public List<Subject> getAllSubjectsTeachedByTeacher(@PathVariable Long teacherId) {
        List<TeacherSubject> teacherSubjectList = teacherSubjectService.getAllSubjectsTeachedByTeacher(teacherId);
        List<Subject> subjects = new ArrayList<>();
        Subject subject = new Subject();
        for (TeacherSubject t : teacherSubjectList) {
            subject = subjectService.getSubject(t.getSubjectId());
            subjects.add(subject);
        }
        return subjects;
    }
}



