package com.alaa.school.repository;

import com.alaa.school.domain.DailySessionDistributed;
import com.alaa.school.domain.DailySessionDistributedPkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DailySessionDistributedRepository
        extends JpaRepository<DailySessionDistributed, DailySessionDistributedPkId> {
    List<DailySessionDistributed> findAllByDailySessionsId(Long dailySession);

    List<DailySessionDistributed> findAllByTeacherSubjectTeacherId(long teacherId);

    @Query("From DailySessionDistributed where teacherSubjectTeacherId=:teacher_id and teacherSubjectSubjectId=:subject_id")
    List<DailySessionDistributed> getTeacherSubjectDailyWeekSession(Long teacher_id, Long subject_id);

    @Modifying
    @Transactional
    @Query("DELETE   From DailySessionDistributed  WHERE teacherSubjectTeacherId=:teacher_id " +
            "AND teacherSubjectSubjectId=:subject_id AND classId=:class_id AND sessionId=:session_id AND dailySessionsId=:daily_sessions_id")
    Integer deleteTeacherSubjectOnSessionOnExactlyDay(Long teacher_id, Long subject_id, Long class_id, Long session_id, Long daily_sessions_id);
}



