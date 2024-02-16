package com.alaa.school.service;

import com.alaa.school.domain.Subject;
import com.alaa.school.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public String addSubject(Subject subject) {
        Subject subjectAdded = new Subject();
        subjectAdded.setName(subject.getName());
        subjectAdded.setDescription(subject.getDescription());
        List<Subject> allExistSubject = subjectRepository.findAll();
        for (Subject s : allExistSubject) {
            if (s.getName().equals(subjectAdded.getName())) {
                return "subject is exist";
            }
        }
        return subjectRepository.save(subjectAdded) + "added";
    }

    public Subject getSubject(Long subjectId) {
        return subjectRepository.findById(subjectId).orElseThrow(
                () -> new RuntimeException("subject does not exist with id: " + subjectId)
        );
    }
}


