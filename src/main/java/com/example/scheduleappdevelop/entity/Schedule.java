package com.example.scheduleappdevelop.entity;

import com.example.scheduleappdevelop.dto.response.ScheduleResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String todo;

    public Schedule(String name, String title, String todo) {
        this.name = name;
        this.title = title;
        this.todo = todo;
    }

    public void update(String title, String todo) {
        this.title = title;
        this.todo = todo;
    }
}
