package com.poc_smartlead.smartlead_wrapper.repository;

import com.poc_smartlead.smartlead_wrapper.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
} 