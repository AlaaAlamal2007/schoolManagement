package com.alaa.school.service;

import com.alaa.school.domain.DailySessionDistributed;
import com.alaa.school.repository.*;
import com.alaa.school.utils.ExcelDailySessionsExportUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DailySessionService {
    private final DailySessionRepository dailySessionRepository;
    private final DailySessionDistributedRepository dailySessionDistributedRepository;
    private final TeacherRepository teacherRepository;
    private final ClassInSchoolRepository classInSchoolRepository;
    private final SubjectRepository subjectRepository;

    private final SessionRepository sessionRepository;

    public DailySessionService(DailySessionRepository dailySessionRepository, DailySessionDistributedRepository dailySessionDistributedRepository, TeacherRepository teacherRepository, ClassInSchoolRepository classInSchoolRepository, SubjectRepository subjectRepository, SessionRepository sessionRepository) {
        this.dailySessionRepository = dailySessionRepository;
        this.dailySessionDistributedRepository = dailySessionDistributedRepository;
        this.teacherRepository = teacherRepository;
        this.classInSchoolRepository = classInSchoolRepository;
        this.subjectRepository = subjectRepository;
        this.sessionRepository = sessionRepository;
    }

    public List<DailySessionDistributed> getAllSessionOnDay(Long dailySession) {
        return dailySessionDistributedRepository.findAllByDailySessionsId(dailySession);
    }

    public void exportDailySessionsToExcel(HttpServletResponse response) throws IOException {
        List<DailySessionDistributed> dsDistributed = dailySessionDistributedRepository.findAll();
        ExcelDailySessionsExportUtils exportUtils = new ExcelDailySessionsExportUtils(dsDistributed, teacherRepository, classInSchoolRepository,
                subjectRepository, dailySessionRepository, sessionRepository);
        exportUtils.exportDailySessionsToExcel(response);
    }
}


