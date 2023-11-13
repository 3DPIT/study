package com.example.di.basic;

import com.example.di.basic.discount.DiscountPolicy;
import com.example.di.basic.discount.RateDiscountPolicy;
import com.example.di.basic.member.MemberService;
import com.example.di.basic.member.MemberServiceImpl;
import com.example.di.basic.member.MemoryMemberRepository;
import com.example.di.basic.order.OrderService;
import com.example.di.basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
            return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
