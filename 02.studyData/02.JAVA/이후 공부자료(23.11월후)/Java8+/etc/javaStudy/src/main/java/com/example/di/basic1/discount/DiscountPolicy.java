package com.example.di.basic1.discount;

import com.example.di.basic1.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount (Member member, int price);
}

