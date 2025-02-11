package com.example.scheduleappdevelop.controller;

import com.example.scheduleappdevelop.dto.request.ScheduleRequestDto;
import com.example.scheduleappdevelop.dto.response.ScheduleResponseDto;
import com.example.scheduleappdevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@Validated @RequestBody ScheduleRequestDto dto) {
        ScheduleResponseDto schedule = scheduleService.save(dto);
        return new ResponseEntity<>(schedule, HttpStatus.CREATED);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        return ResponseEntity.ok(scheduleService.findAll());
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.findById(id));
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> update(
            @PathVariable Long id,
            @Validated @RequestBody ScheduleRequestDto dto
    ) {
        return ResponseEntity.ok(scheduleService.update(id, dto.getName(), dto.getTitle(), dto.getTodo()));
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        scheduleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
