package com.example.scheduleappdevelop.service;

import com.example.scheduleappdevelop.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final SchedulerRepository schedulerRepository;

}
