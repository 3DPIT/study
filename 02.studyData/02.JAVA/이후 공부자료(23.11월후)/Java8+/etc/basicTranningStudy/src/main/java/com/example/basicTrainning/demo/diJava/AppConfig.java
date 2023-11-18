package com.example.basicTrainning.demo.diJava;

import com.example.basicTrainning.demo.diJava.discount.DiscountPolicy;
import com.example.basicTrainning.demo.diJava.discount.FixedDiscountPolicy;
import com.example.basicTrainning.demo.diJava.member.MemberRepository;
import com.example.basicTrainning.demo.diJava.member.MemberService;
import com.example.basicTrainning.demo.diJava.member.MemberServiceImpl;
import com.example.basicTrainning.demo.diJava.member.MemoryMemberRepository;
import com.example.basicTrainning.demo.diJava.order.OrderService;
import com.example.basicTrainning.demo.diJava.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService (){
        return new MemberServiceImpl(memberRepository());
    }

    private  MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixedDiscountPolicy();
    }
}
