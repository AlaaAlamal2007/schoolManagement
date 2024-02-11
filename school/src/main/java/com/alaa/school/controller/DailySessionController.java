package com.alaa.school.controller;

import com.alaa.school.domain.DailySession;
import com.alaa.school.domain.DailySessionDistributed;
import com.alaa.school.service.DailySessionService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/daily-sessions")
public class DailySessionController {
    private final DailySessionService dailySessionService;

    public DailySessionController(DailySessionService dailySessionService) {
        this.dailySessionService = dailySessionService;
    }

    @PostMapping
    public DailySession addSessionsToDay(@RequestBody DailySession dailySession) {
        return dailySessionService.addSessionsToDay(dailySession);
    }

    @GetMapping("/{dailySession}")
    public List<DailySessionDistributed> getAllSessionOnDay(@PathVariable Long dailySession) {
        return dailySessionService.getAllSessionOnDay(dailySession);
    }

    @GetMapping("/export-to-excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=daily_sessions.xlsx";
        response.setHeader(headerKey, headerValue);
        dailySessionService.exportDailySessionsToExcel(response);
    }
}


