package com.alaa.school.controller;

import com.alaa.school.domain.DailySessionDistributed;
import com.alaa.school.domain.TeacherSubject;
import com.alaa.school.service.DailySessionDistributedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily-sessions-distributed")
public class DailySessionDistributedController {
    private final DailySessionDistributedService dailySessionDistributedService;

    public DailySessionDistributedController(DailySessionDistributedService dailySessionDistributedService) {
        this.dailySessionDistributedService = dailySessionDistributedService;
    }

    @PostMapping
    public String addDailySessionDistributed(@RequestBody DailySessionDistributed dsDistributed) {
        DailySessionDistributed dsd = dailySessionDistributedService.addDailySessionDistributed(dsDistributed);
        if (dsd == null) {
            return "already teacher has session on  another class ";
        }
        return dsd + "added";
    }

    /*
    get TeacherSubject sessions through weeks
     */
    @GetMapping("/{teacherId}/{subjectId}")
    public List<DailySessionDistributed> getTeacherSubjectsWeeklySessions(@PathVariable Long teacherId, @PathVariable Long subjectId) {
        return dailySessionDistributedService.getTeacherSubjectsWeeklySessions(teacherId, subjectId);
    }

    /*
    get TeacherSubject on anySession on day
     */
    @GetMapping("/sessionId/{sessionId}/{dailySessionId}")
    public List<TeacherSubject> getTeacherSubjectOnSession(@PathVariable Long sessionId, @PathVariable Long dailySessionId) {
        return dailySessionDistributedService.getTeacherSubjectOnSession(sessionId, dailySessionId);
    }

    @PutMapping("/update/{sessionId}/{dailySessionId}")
    public DailySessionDistributed updateTeacherSubjectOnSession(@PathVariable Long sessionId,
                                                                 @PathVariable Long dailySessionId,
                                                                 @RequestBody DailySessionDistributed dsd) {
        return dailySessionDistributedService.updateTeacherSubjectOnSession(sessionId, dailySessionId, dsd);
    }

    /*
    Delete TeacherSubject On session and classId through all weeksDay
     */
    @DeleteMapping("/delete/{teacherId}/{subjectId}/{classId}/{sessionId}")
    public void deleteTeacherSubjectOnSession(@PathVariable Long teacherId,
                                              @PathVariable Long subjectId,
                                              @PathVariable Long classId,
                                              @PathVariable Long sessionId) {
        dailySessionDistributedService.deleteTeacherSubjectOnSession(teacherId, subjectId, classId, sessionId);
    }

    /*
    Delete TeacherSubject for specified class and session on exactly day
     */
    @DeleteMapping("/delete-exactly-session/{teacherId}/{subjectId}/{classId}/{sessionId}/{dailySessionsId}")
    public void deleteTeacherSubjectOnSessionOnExactlyDay(
            @PathVariable Long teacherId,
            @PathVariable Long subjectId,
            @PathVariable Long classId,
            @PathVariable Long sessionId,
            @PathVariable Long dailySessionsId
    ) {
        dailySessionDistributedService.deleteTeacherSubjectOnSessionOnExactlyDay(teacherId, subjectId, classId, sessionId, dailySessionsId);
    }
}


