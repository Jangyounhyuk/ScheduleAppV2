package com.example.scheduleappdevelop.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MemberRequestDto {

    @NotBlank(message = "name은 필수값입니다.")
    private String name;
    @NotBlank(message = "email은 필수값입니다.")
    @Email
    private String email;
}
