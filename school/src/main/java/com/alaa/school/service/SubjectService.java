package com.alaa.school.service;

import com.alaa.school.domain.Subject;
import com.alaa.school.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject addSubject(Subject subject) {
        Subject subjectAdded = new Subject();
        subjectAdded.setName(subject.getName());
        subjectAdded.setDescription(subject.getDescription());
        return subjectRepository.save(subjectAdded);
    }

    public Subject getSubject(Long subjectId) {
        return subjectRepository.findById(subjectId).orElseThrow(
                () -> new RuntimeException("subject does not exist with id: " + subjectId)
        );
    }
}

