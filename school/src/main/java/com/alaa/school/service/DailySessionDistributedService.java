package com.alaa.school.service;

import com.alaa.school.domain.DailySessionDistributed;
import com.alaa.school.repository.DailySessionDistributedRepository;
import org.springframework.stereotype.Service;

@Service
public class DailySessionDistributedService {
    private final DailySessionDistributedRepository dailySessionDistributedRepository;

    public DailySessionDistributedService(DailySessionDistributedRepository dailySessionDistributedRepository) {
        this.dailySessionDistributedRepository = dailySessionDistributedRepository;
    }

    public DailySessionDistributed addDailySessionDistributed(DailySessionDistributed dsDistributed) {
        DailySessionDistributed dsDistributedAdded = new DailySessionDistributed();
        dsDistributedAdded.setTeacherId(dsDistributed.getTeacherId());
        dsDistributedAdded.setSubjectId(dsDistributed.getSubjectId());
        dsDistributedAdded.setClassId(dsDistributed.getClassId());
        dsDistributedAdded.setSessionId(dsDistributed.getSessionId());
        dsDistributedAdded.setDailySessionsId(dsDistributed.getDailySessionsId());
        return dailySessionDistributedRepository.save(dsDistributedAdded);
    }
}

