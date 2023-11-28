package com.example.basicTrainning.demo.sigleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void noStatefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        NoStatefulService statefulService1 = ac.getBean(NoStatefulService.class);
        NoStatefulService statefulService2 = ac.getBean(NoStatefulService.class);

        //A사용자가 10000를 주문
        statefulService1.order("userA", 10000);

        //B사용자가 200000 주문
        statefulService2.order("userB", 20000);

        int price = statefulService1.getPrice();

        System.out.println("price = " + price );

        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    @Test
    void StatefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //A사용자가 10000를 주문
        int userA_Price = statefulService1.order("userA", 10000);

        //B사용자가 200000 주문
        int userB_Price= statefulService2.order("userB", 20000);

        System.out.println("price = " + userA_Price );

        org.assertj.core.api.Assertions.assertThat(userA_Price).isEqualTo(10000);

    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

        @Bean
        public NoStatefulService noStatefulService(){
            return new NoStatefulService();
        }
    }

}