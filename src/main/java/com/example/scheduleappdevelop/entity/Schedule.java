package com.example.scheduleappdevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String todo;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Schedule(String name, String title, String todo) {
        this.name = name;
        this.title = title;
        this.todo = todo;
    }

    public void update(String name, String title, String todo) {
        this.name = name;
        this.title = title;
        this.todo = todo;
    }
}
