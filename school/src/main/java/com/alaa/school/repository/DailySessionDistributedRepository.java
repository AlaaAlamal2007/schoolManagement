package com.alaa.school.repository;

import com.alaa.school.domain.DailySessionDistributed;
import com.alaa.school.domain.DailySessionDistributedPkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailySessionDistributedRepository
        extends JpaRepository<DailySessionDistributed, DailySessionDistributedPkId> {
    List<DailySessionDistributed> findAllByDailySessionsId(Long dailySession);
}


