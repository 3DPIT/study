package com.expample.di.basic.discount;

import com.expample.di.basic.member.Grade;
import com.expample.di.basic.member.Member;

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
