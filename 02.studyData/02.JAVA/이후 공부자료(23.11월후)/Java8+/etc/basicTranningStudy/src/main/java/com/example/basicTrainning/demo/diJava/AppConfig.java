package com.example.basicTrainning.demo.diJava;

import com.example.basicTrainning.demo.diJava.discount.DiscountPolicy;
import com.example.basicTrainning.demo.diJava.discount.FixedDiscountPolicy;
import com.example.basicTrainning.demo.diJava.member.MemberRepository;
import com.example.basicTrainning.demo.diJava.member.MemberService;
import com.example.basicTrainning.demo.diJava.member.MemberServiceImpl;
import com.example.basicTrainning.demo.diJava.member.MemoryMemberRepository;
import com.example.basicTrainning.demo.diJava.order.OrderService;
import com.example.basicTrainning.demo.diJava.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService (){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public  MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixedDiscountPolicy();
    }
}
