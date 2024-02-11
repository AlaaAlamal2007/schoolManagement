package com.alaa.school.service;

import com.alaa.school.domain.TeacherSubject;
import com.alaa.school.repository.TeacherSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherSubjectService {
    private final TeacherSubjectRepository teacherSubjectRepository;

    public TeacherSubjectService(TeacherSubjectRepository teacherSubjectRepository) {
        this.teacherSubjectRepository = teacherSubjectRepository;
    }

    public TeacherSubject assignTeacherToSubject(TeacherSubject teacherSubject) {
        TeacherSubject teacherSubjectAdded = new TeacherSubject();
        teacherSubjectAdded.setTeacherId(teacherSubject.getTeacherId());
        teacherSubjectAdded.setSubjectId(teacherSubject.getSubjectId());
        teacherSubjectAdded.setNumberTakenClass(teacherSubject.getNumberTakenClass());
        return teacherSubjectRepository.save(teacherSubjectAdded);
    }

    public List<TeacherSubject> getAllTeacherTeachesSubject(Long subjectId) {
        return teacherSubjectRepository.findBySubjectId(subjectId);
    }

    public List<TeacherSubject> getAllSubjectsTeachedByTeacher(Long teacherId) {
        return teacherSubjectRepository.findByTeacherId(teacherId);
    }
}

