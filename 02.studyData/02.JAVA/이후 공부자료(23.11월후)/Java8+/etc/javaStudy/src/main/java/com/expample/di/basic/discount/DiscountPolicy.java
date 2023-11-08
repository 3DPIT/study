package com.expample.di.basic.discount;

import com.expample.di.basic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
