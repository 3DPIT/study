package com.example.di.basic1;

import com.example.di.basic1.member.Grade;
import com.example.di.basic1.member.Member;
import com.example.di.basic1.member.MemberService;
import com.example.di.basic1.member.MemberServiceImpl;
import com.example.di.basic1.order.Order;
import com.example.di.basic1.order.OrderService;
import com.example.di.basic1.order.OrderServiceImpl;

public class App {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId =1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"iphone",10000000);

        System.out.println("order= "+ order);

    }
}
