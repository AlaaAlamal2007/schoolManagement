package com.alaa.school.controller;

import com.alaa.school.domain.DailySessionDistributed;
import com.alaa.school.service.DailySessionDistributedService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/daily-sessions-distributed")
public class DailySessionDistributedController {
    private final DailySessionDistributedService dailySessionDistributedService;

    public DailySessionDistributedController(DailySessionDistributedService dailySessionDistributedService) {
        this.dailySessionDistributedService = dailySessionDistributedService;
    }

    @PostMapping
    public DailySessionDistributed addDailySessionDistributed(@RequestBody DailySessionDistributed dsDistributed){
        return dailySessionDistributedService.addDailySessionDistributed(dsDistributed);
    }
}

