package com.alaa.school.repository;

import com.alaa.school.domain.TeacherSubject;
import com.alaa.school.domain.TeacherSubjectPkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, TeacherSubjectPkId> {
    List<TeacherSubject> findBySubjectId(Long subjectId);

    List<TeacherSubject> findByTeacherId(Long teacherId);

    @Query("From TeacherSubject ts LEFT JOIN DailySessionDistributed dsd on(ts.teacherId=dsd.teacherSubjectTeacherId AND ts.subjectId=dsd.teacherSubjectSubjectId) WHERE dsd.sessionId=:session_id AND dsd.dailySessionsId=:daily_sessions_id")
    public List<TeacherSubject> getTeacherSubjectInfo(Long session_id, Long daily_sessions_id);
}


