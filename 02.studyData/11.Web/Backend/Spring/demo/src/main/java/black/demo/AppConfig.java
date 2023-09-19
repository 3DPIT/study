package black.demo;

import black.demo.discount.DiscountPolicy;
import black.demo.discount.FixDiscountPolicy;
import black.demo.discount.RateDiscountPolicy;
import black.demo.member.MemberRepositioryImpl;
import black.demo.member.MemberRepository;
import black.demo.member.MemberService;
import black.demo.member.MemberServiceImpl;
import black.demo.order.OrderService;
import black.demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemberRepositioryImpl();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
