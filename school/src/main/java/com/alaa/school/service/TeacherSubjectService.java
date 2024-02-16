package com.alaa.school.service;

import com.alaa.school.domain.Subject;
import com.alaa.school.domain.Teacher;
import com.alaa.school.domain.TeacherSubject;
import com.alaa.school.exceptions.SubjectResourceException;
import com.alaa.school.exceptions.TeacherResourceException;
import com.alaa.school.repository.SubjectRepository;
import com.alaa.school.repository.TeacherRepository;
import com.alaa.school.repository.TeacherSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherSubjectService {
    private final TeacherSubjectRepository teacherSubjectRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public TeacherSubjectService(TeacherSubjectRepository teacherSubjectRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherSubjectRepository = teacherSubjectRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    public String assignTeacherToSubject(TeacherSubject teacherSubject) {
        validateTeacherSubject(teacherSubject);
        teacherRepository.findById(teacherSubject.getTeacherId()).orElseThrow(
                () -> new TeacherResourceException("teacher does not exist " + teacherSubject.getTeacherId()));
        subjectRepository.findById(teacherSubject.getSubjectId()).orElseThrow(
                () -> new SubjectResourceException("subject does not exist " + teacherSubject.getSubjectId())
        );
        List<TeacherSubject> teacherSubjectList = teacherSubjectRepository.findAll();
        for (TeacherSubject ts : teacherSubjectList) {
            if (ts.getTeacherId() == teacherSubject.getTeacherId() &&
                    ts.getSubjectId() == teacherSubject.getSubjectId()) {
                return "teacher assigned to subject exist ";
            }
        }
        TeacherSubject teacherSubjectAdded = new TeacherSubject();
        teacherSubjectAdded.setTeacherId(teacherSubject.getTeacherId());
        teacherSubjectAdded.setSubjectId(teacherSubject.getSubjectId());
        teacherSubjectAdded.setNumberTakenClass(teacherSubject.getNumberTakenClass());
        return teacherSubjectRepository.save(teacherSubjectAdded) + "Added";
    }

    private void validateTeacherSubject(TeacherSubject teacherSubject) {
        Teacher teacher = teacherRepository.findById(teacherSubject.getTeacherId()).orElseThrow(
                () -> new TeacherResourceException("Teacher does not exist " + teacherSubject.getTeacherId())
        );
        Subject subject = subjectRepository.findById(teacherSubject.getSubjectId()).orElseThrow(
                () -> new SubjectResourceException("Subject does not exist " + teacherSubject.getSubjectId()
                ));
    }

    public List<TeacherSubject> getAllTeacherTeachesSubject(Long subjectId) {
        return teacherSubjectRepository.findBySubjectId(subjectId);
    }

    public List<TeacherSubject> getAllSubjectsTeachedByTeacher(Long teacherId) {
        return teacherSubjectRepository.findByTeacherId(teacherId);
    }
}


