package com.example.basicTrainning.demo.diJava;

import com.example.basicTrainning.demo.diJava.discount.DiscountPolicy;
import com.example.basicTrainning.demo.diJava.member.MemberRepository;
import com.example.basicTrainning.demo.diJava.member.MemoryMemberRepository;
import com.example.basicTrainning.demo.diJava.order.OrderService;
import com.example.basicTrainning.demo.diJava.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//시작 위치 적용
        //basePackages = "com.example.basicTrainning.demo.diJava.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 이렇게 해도 된다.
//    @Autowired MemberRepository memberRepository;
//    @Autowired
//    DiscountPolicy discountPolicy;
//    @Bean
//    OrderService orderService(){
//        return new OrderServiceImpl(memberRepository,discountPolicy);
//    }
    @Bean(name ="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}