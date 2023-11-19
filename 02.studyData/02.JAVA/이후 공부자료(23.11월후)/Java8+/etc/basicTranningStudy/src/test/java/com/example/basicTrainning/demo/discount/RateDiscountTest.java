package com.example.basicTrainning.demo.discount;

import com.example.basicTrainning.demo.diJava.AppConfig;
import com.example.basicTrainning.demo.diJava.discount.DiscountPolicy;
import com.example.basicTrainning.demo.diJava.discount.RateDiscount;
import com.example.basicTrainning.demo.diJava.member.Grade;
import com.example.basicTrainning.demo.diJava.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountTest {
    DiscountPolicy discountPolicy;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        discountPolicy = new RateDiscount();
    }

    @Test
    @DisplayName("vip는 10프로 할인 적용")
    void vip_o(){
        ///given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);

        //then
    }
}
