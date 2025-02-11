package com.example.scheduleappdevelop.controller;

import com.example.scheduleappdevelop.dto.request.MemberRequestDto;
import com.example.scheduleappdevelop.dto.response.MemberResponseDto;
import com.example.scheduleappdevelop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MemberResponseDto> save(@Validated @RequestBody MemberRequestDto dto) {
        return new ResponseEntity<>(memberService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponseDto>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberResponseDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<MemberResponseDto> update(
            @PathVariable Long id,
            @Validated @RequestBody MemberRequestDto dto
    ) {
        return ResponseEntity.ok(memberService.update(id, dto));
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
