package com.example.javastudy.discount;

import com.example.di.basic.discount.RateDiscountPolicy;
import com.example.di.basic.member.Grade;
import com.example.di.basic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10%할인이 적용되어야함")
    void vip_o(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("BAIC 10%할인이 적용되지 않음")
    void vip_x(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
