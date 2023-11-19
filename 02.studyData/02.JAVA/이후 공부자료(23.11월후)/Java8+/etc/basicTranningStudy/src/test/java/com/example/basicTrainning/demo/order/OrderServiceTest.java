package com.example.basicTrainning.demo.order;

import com.example.basicTrainning.demo.diJava.AppConfig;
import com.example.basicTrainning.demo.diJava.member.Grade;
import com.example.basicTrainning.demo.diJava.member.Member;
import com.example.basicTrainning.demo.diJava.member.MemberService;
import com.example.basicTrainning.demo.diJava.order.Order;
import com.example.basicTrainning.demo.diJava.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService= appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "mac pro", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
