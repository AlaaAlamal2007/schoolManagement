package com.alaa.school.repository;

import com.alaa.school.domain.DailySession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailySessionRepository extends JpaRepository<DailySession, Long> {
}

