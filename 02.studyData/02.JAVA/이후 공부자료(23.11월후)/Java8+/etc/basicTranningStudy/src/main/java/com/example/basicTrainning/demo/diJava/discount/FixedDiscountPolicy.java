package com.example.basicTrainning.demo.diJava.discount;

import com.example.basicTrainning.demo.diJava.member.Grade;
import com.example.basicTrainning.demo.diJava.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount =1000;
    @Override
    public int discount(Member member, int price) {

        if(member.getGrede() == Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
