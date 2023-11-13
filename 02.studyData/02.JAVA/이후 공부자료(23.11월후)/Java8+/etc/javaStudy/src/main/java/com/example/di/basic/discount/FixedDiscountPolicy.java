package com.example.di.basic.discount;

import com.example.di.basic.member.Grade;
import com.example.di.basic.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
