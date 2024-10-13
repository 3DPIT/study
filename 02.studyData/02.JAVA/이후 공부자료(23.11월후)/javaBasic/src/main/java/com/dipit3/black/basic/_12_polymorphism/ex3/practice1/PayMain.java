package com.dipit3.black.basic._12_polymorphism.ex3.practice1;

public class PayMain {
    public static void main(String[] args) {

        PayService payService = new PayService();

        // 카카오 결제
        String payOption1 = "kakao";
        int amount1 = 1000;
        payService.processPay(payOption1, amount1);

        // 네이버 결제
        String payOption2 = "naver";
        int amount2 = 2000;
        payService.processPay(payOption2, amount2);

        // 잘못된 결제 수단 (결제 수단이 존재 하지 않는 경우) 선택
        String payOption3 = "apple";
        int amount3 = 3000;
        payService.processPay(payOption3, amount3);


    }
}
