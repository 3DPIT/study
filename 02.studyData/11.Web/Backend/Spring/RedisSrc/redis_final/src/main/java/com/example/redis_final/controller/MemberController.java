package com.example.redis_final.controller;

import com.example.redis_final.data.Member;
import com.example.redis_final.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping
    public Member save(@RequestBody Member member){
        Member saveMember = memberRepository.save(member);
        log.info("save to DB : " + member);
        return saveMember;
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", cacheNames = "member")
    public Member getMember(@PathVariable Long id){
        Member findMember = memberRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " 멤버는 존재하지 않습니다."));
        log.info("Member fetching from DB : "  + id);
        return findMember;
    }
}