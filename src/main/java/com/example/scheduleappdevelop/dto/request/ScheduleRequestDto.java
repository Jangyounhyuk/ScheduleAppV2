package com.example.scheduleappdevelop.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    @NotBlank(message = "title은 필수값입니다.")
    private String title;
    @NotBlank(message = "todo는 필수값입니다.")
    private String todo;
    private Long memberId;
}
