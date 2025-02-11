package com.example.scheduleappdevelop.repository;

import com.example.scheduleappdevelop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
