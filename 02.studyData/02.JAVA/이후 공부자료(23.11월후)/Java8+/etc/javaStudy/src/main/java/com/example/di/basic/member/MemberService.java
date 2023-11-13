package com.example.di.basic.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
