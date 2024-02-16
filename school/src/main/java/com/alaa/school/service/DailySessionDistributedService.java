package com.alaa.school.service;

import com.alaa.school.domain.*;
import com.alaa.school.exceptions.SubjectResourceException;
import com.alaa.school.exceptions.TeacherResourceException;
import com.alaa.school.exceptions.TeacherSubjectResourceException;
import com.alaa.school.repository.DailySessionDistributedRepository;
import com.alaa.school.repository.SubjectRepository;
import com.alaa.school.repository.TeacherRepository;
import com.alaa.school.repository.TeacherSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailySessionDistributedService {
    private final DailySessionDistributedRepository dailySessionDistributedRepository;
    private final TeacherSubjectRepository teacherSubjectRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public DailySessionDistributedService(DailySessionDistributedRepository dailySessionDistributedRepository, TeacherSubjectRepository teacherSubjectRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.dailySessionDistributedRepository = dailySessionDistributedRepository;
        this.teacherSubjectRepository = teacherSubjectRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    public DailySessionDistributed addDailySessionDistributed(DailySessionDistributed dsDistributed) {
        validateAddDailySessionsDistributed(dsDistributed);
        DailySessionDistributed isExistDailySessionsDistributed = dailySessionDistributedRepository.findById(new DailySessionDistributedPkId(dsDistributed.getTeacherSubjectTeacherId(), dsDistributed.getTeacherSubjectSubjectId(), dsDistributed.getClassId(), dsDistributed.getSessionId())).orElse(null);
        if (isExistDailySessionsDistributed == null) {
            if (!isTeacherSubjectExistOnSession(dsDistributed.getSessionId(), dsDistributed.getDailySessionsId(), dsDistributed)) {
                DailySessionDistributed dsDistributedAdded = new DailySessionDistributed();
                dsDistributedAdded.setTeacherSubjectTeacherId(dsDistributed.getTeacherSubjectTeacherId());
                dsDistributedAdded.setTeacherSubjectSubjectId(dsDistributed.getTeacherSubjectSubjectId());
                dsDistributedAdded.setClassId(dsDistributed.getClassId());
                dsDistributedAdded.setSessionId(dsDistributed.getSessionId());
                dsDistributedAdded.setDailySessionsId(dsDistributed.getDailySessionsId());
                return dailySessionDistributedRepository.save(dsDistributedAdded);
            }
        }
        return isExistDailySessionsDistributed;
    }

    private void validateAddDailySessionsDistributed(DailySessionDistributed dsDistributed) {
        Teacher teacher = teacherRepository.findById(dsDistributed.getTeacherSubjectTeacherId()).orElseThrow(
                () -> new TeacherResourceException("Teacher does not exist " + dsDistributed.getTeacherSubjectTeacherId())
        );
        Subject subject = subjectRepository.findById(dsDistributed.getTeacherSubjectSubjectId()).orElseThrow(
                () -> new SubjectResourceException("Subject does not exist ")
        );
        TeacherSubject teacherSubject = teacherSubjectRepository.
                findById(new TeacherSubjectPkId(dsDistributed.getTeacherSubjectTeacherId(), dsDistributed.getTeacherSubjectSubjectId()))
                .orElseThrow(() -> new TeacherSubjectResourceException("teacher does not assigned to subject"));
    }

    public List<DailySessionDistributed> getTeacherSubjectsWeeklySessions(Long teacherId, Long subjectId) {
        return dailySessionDistributedRepository.getTeacherSubjectDailyWeekSession(teacherId, subjectId);
    }

    public List<TeacherSubject> getTeacherSubjectOnSession(Long sessionId, Long dailySessionId) {
        return teacherSubjectRepository.getTeacherSubjectInfo(sessionId, dailySessionId);
    }

    public DailySessionDistributed updateTeacherSubjectOnSession(Long sessionId, Long dailySessionId,
                                                                 DailySessionDistributed dsd) {
        validateAddDailySessionsDistributed(dsd);
        boolean isExistTeacherSubject = isTeacherSubjectExistOnSession(sessionId, dailySessionId, dsd);
        if (isExistTeacherSubject) {
            dailySessionDistributedRepository.deleteTeacherSubjectOnSessionOnExactlyDay(dsd.getTeacherSubjectTeacherId(), dsd.getTeacherSubjectSubjectId(), dsd.getClassId(), sessionId, dailySessionId);
        }
        DailySessionDistributed dsDistributedAdded = new DailySessionDistributed();
        dsDistributedAdded.setTeacherSubjectTeacherId(dsd.getTeacherSubjectTeacherId());
        dsDistributedAdded.setTeacherSubjectSubjectId(dsd.getTeacherSubjectSubjectId());
        dsDistributedAdded.setClassId(dsd.getClassId());
        dsDistributedAdded.setSessionId(dsd.getSessionId());
        dsDistributedAdded.setDailySessionsId(dsd.getDailySessionsId());
        return dailySessionDistributedRepository.saveAndFlush(dsDistributedAdded);

    }

    /*
    Ensure that teacherSubject does not teach any class on this session
 */
    private boolean isTeacherSubjectExistOnSession(Long sessionId, Long dailySessionId, DailySessionDistributed dsd) {
        List<TeacherSubject> teacherSubjectList =
                teacherSubjectRepository.getTeacherSubjectInfo(sessionId, dailySessionId);

        TeacherSubject teacherSubject = teacherSubjectRepository.findById(new TeacherSubjectPkId(dsd.getTeacherSubjectTeacherId(), dsd.getTeacherSubjectSubjectId()))
                .orElseThrow(() -> new TeacherSubjectResourceException("teacherSubject does not exist"));
        boolean isTeacherSubject = teacherSubjectList.stream().filter(ts -> ts != null).peek((ts) -> System.out.println(ts.equals(teacherSubject))).anyMatch((ts) -> ts.equals(teacherSubject));
        return isTeacherSubject;
    }

    public void deleteTeacherSubjectOnSession(Long teacherId, Long subjectId, Long classId, Long sessionId) {
        dailySessionDistributedRepository.deleteById(new DailySessionDistributedPkId(teacherId, subjectId, classId, sessionId));
    }

    public void deleteTeacherSubjectOnSessionOnExactlyDay(Long teacherId, Long subjectId, Long classId, Long sessionId, Long dailySessionsId) {
        dailySessionDistributedRepository.deleteTeacherSubjectOnSessionOnExactlyDay(teacherId, subjectId, classId, sessionId, dailySessionsId);

    }
}




