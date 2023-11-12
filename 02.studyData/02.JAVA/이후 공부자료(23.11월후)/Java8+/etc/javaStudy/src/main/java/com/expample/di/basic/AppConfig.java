package com.expample.di.basic;

import com.expample.di.basic.discount.DiscountPolicy;
import com.expample.di.basic.discount.FixedDiscountPolicy;
import com.expample.di.basic.discount.RateDiscountPolicy;
import com.expample.di.basic.member.MemberService;
import com.expample.di.basic.member.MemberServiceImpl;
import com.expample.di.basic.member.MemoryMemberRepository;
import com.expample.di.basic.order.OrderService;
import com.expample.di.basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
            return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public  MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public  DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
