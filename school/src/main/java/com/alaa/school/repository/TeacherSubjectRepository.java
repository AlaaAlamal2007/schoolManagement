package com.alaa.school.repository;

import com.alaa.school.domain.TeacherSubject;
import com.alaa.school.domain.TeacherSubjectPkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, TeacherSubjectPkId> {
    List<TeacherSubject> findBySubjectId(Long subjectId);

    List<TeacherSubject> findByTeacherId(Long teacherId);
}

