package com.example.basicTrainning.demo.diJava.discount;

import com.example.basicTrainning.demo.diJava.member.Grade;
import com.example.basicTrainning.demo.diJava.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscount implements DiscountPolicy{
    private int discountPercent =10;
    @Override
    public int discount(Member member, int price) {

        if(member.getGrede()== Grade.VIP){
            return price * discountPercent /100;
        }

        return 0;
    }
}
