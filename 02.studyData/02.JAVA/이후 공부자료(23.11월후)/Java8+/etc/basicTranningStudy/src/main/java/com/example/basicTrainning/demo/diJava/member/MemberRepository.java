package com.example.basicTrainning.demo.diJava.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
