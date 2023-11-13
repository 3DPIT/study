package com.example.di.basic1.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
