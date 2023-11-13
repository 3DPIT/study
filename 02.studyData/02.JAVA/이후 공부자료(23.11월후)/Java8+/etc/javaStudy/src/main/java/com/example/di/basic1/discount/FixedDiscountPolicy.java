package com.example.di.basic1.discount;

import com.example.di.basic1.member.Grade;
import com.example.di.basic1.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 3000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
