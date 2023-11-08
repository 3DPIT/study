package com.example.javastudy.order;

import com.expample.di.basic.AppConfig;
import com.expample.di.basic.member.Grade;
import com.expample.di.basic.member.Member;
import com.expample.di.basic.member.MemberService;
import com.expample.di.basic.member.MemberServiceImpl;
import com.expample.di.basic.order.Order;
import com.expample.di.basic.order.OrderService;
import com.expample.di.basic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService  = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "콜라", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
