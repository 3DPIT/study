package com.expample.di.basic;

import com.expample.di.basic.discount.FixedDiscountPolicy;
import com.expample.di.basic.member.MemberService;
import com.expample.di.basic.member.MemberServiceImpl;
import com.expample.di.basic.member.MemoryMemberRepository;
import com.expample.di.basic.order.OrderService;
import com.expample.di.basic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixedDiscountPolicy());
    }
}
