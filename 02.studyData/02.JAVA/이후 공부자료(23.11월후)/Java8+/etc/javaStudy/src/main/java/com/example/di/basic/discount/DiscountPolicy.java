package com.example.di.basic.discount;

import com.example.di.basic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
