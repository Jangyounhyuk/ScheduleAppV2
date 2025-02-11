package com.example.scheduleappdevelop.service;

import com.example.scheduleappdevelop.dto.request.ScheduleRequestDto;
import com.example.scheduleappdevelop.dto.response.ScheduleResponseDto;
import com.example.scheduleappdevelop.entity.Schedule;
import com.example.scheduleappdevelop.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final SchedulerRepository schedulerRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getTitle(), dto.getTodo());
        Schedule savedSchedule = schedulerRepository.save(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getTodo(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {

        List<Schedule> schedules = schedulerRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(
                            schedule.getId(),
                            schedule.getTitle(),
                            schedule.getTodo(),
                            schedule.getCreatedAt(),
                            schedule.getUpdatedAt()
                    )
            );
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule findSchedule = schedulerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id 일정 없음")
        );
        return new ScheduleResponseDto(
                findSchedule.getId(),
                findSchedule.getTitle(),
                findSchedule.getTodo(),
                findSchedule.getCreatedAt(),
                findSchedule.getUpdatedAt()
        );
    }

    @Transactional
    public ScheduleResponseDto update(Long id, String name, String title, String todo) {
        Schedule findSchedule = schedulerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id 일정 없음")
        );

        findSchedule.update(title, todo);
        return new ScheduleResponseDto(
                findSchedule.getId(),
                findSchedule.getTitle(),
                findSchedule.getTodo(),
                findSchedule.getCreatedAt(),
                findSchedule.getUpdatedAt()
        );
    }

    @Transactional
    public void deleteById(Long id) {
        if (!schedulerRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 id 일정 없음");
        }
        schedulerRepository.deleteById(id);
    }
}
