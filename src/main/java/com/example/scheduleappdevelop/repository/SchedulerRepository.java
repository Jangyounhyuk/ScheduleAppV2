package com.example.scheduleappdevelop.repository;

import com.example.scheduleappdevelop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<Schedule, Long> {
}
