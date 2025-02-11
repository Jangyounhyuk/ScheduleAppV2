package com.example.scheduleappdevelop.service;

import com.example.scheduleappdevelop.dto.request.MemberRequestDto;
import com.example.scheduleappdevelop.dto.response.MemberResponseDto;
import com.example.scheduleappdevelop.entity.Member;
import com.example.scheduleappdevelop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto save(MemberRequestDto dto) {
        Member member = new Member(dto.getName(), dto.getEmail(), dto.getPassword());
        Member savedMember = memberRepository.save(member);
        return new MemberResponseDto(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getEmail(),
                savedMember.getCreatedAt(),
                savedMember.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {

        List<Member> members = memberRepository.findAll();

        List<MemberResponseDto> dtos = new ArrayList<>();
        for (Member member : members) {
            dtos.add(new MemberResponseDto(
                            member.getId(),
                            member.getName(),
                            member.getEmail(),
                            member.getCreatedAt(),
                            member.getUpdatedAt()
                    )
            );
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id) {
        Member findMember = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id 멤버 없음")
        );
        return new MemberResponseDto(
                findMember.getId(),
                findMember.getName(),
                findMember.getEmail(),
                findMember.getCreatedAt(),
                findMember.getUpdatedAt()
        );
    }

    @Transactional
    public MemberResponseDto update(Long id, MemberRequestDto dto) {
        Member findMember = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id 멤버 없음")
        );
        findMember.update(dto.getName(), dto.getEmail(), dto.getPassword());
        return new MemberResponseDto(
                findMember.getId(),
                findMember.getName(),
                findMember.getEmail(),
                findMember.getCreatedAt(),
                findMember.getUpdatedAt()
        );
    }

    @Transactional
    public void deleteById(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 id 멤버 없음");
        }
        memberRepository.deleteById(id);
    }
}
