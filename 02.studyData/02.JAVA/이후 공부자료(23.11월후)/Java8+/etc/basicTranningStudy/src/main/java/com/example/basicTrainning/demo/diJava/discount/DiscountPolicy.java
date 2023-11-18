package com.example.basicTrainning.demo.diJava.discount;

import com.example.basicTrainning.demo.diJava.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
