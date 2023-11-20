package com.example.basicTrainning.demo.beanfind;

import com.example.basicTrainning.demo.diJava.AppConfig;
import com.example.basicTrainning.demo.diJava.member.MemberService;
import com.example.basicTrainning.demo.diJava.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName()
    {
        MemberService  memberService= ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = "+ memberService);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType()
    {
        MemberService  memberService= ac.getBean( MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByName2()
    {
        MemberServiceImpl  memberService= ac.getBean( "memberService",MemberServiceImpl.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX(){
//        MemberService  xxxxx = ac.getBean("xxxx",MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()->ac.getBean("xxxx",MemberService.class));
    }
}
