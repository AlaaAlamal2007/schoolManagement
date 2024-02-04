package com.alaa.school.controller;

import com.alaa.school.domain.ClassInSchool;
import com.alaa.school.service.ClassInSchoolService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes")
public class ClassInSchoolController {
   private final ClassInSchoolService classInSchoolService;

    public ClassInSchoolController(ClassInSchoolService classInSchoolService) {
        this.classInSchoolService = classInSchoolService;
    }

    @GetMapping("/{classId}")
    public ClassInSchool getClassInSchool(@PathVariable Long classId ){
        return classInSchoolService.getClassInSchool(classId);
    }

}
