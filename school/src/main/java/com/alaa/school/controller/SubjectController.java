package com.alaa.school.controller;

import com.alaa.school.domain.Subject;
import com.alaa.school.service.SubjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);

    }
}
