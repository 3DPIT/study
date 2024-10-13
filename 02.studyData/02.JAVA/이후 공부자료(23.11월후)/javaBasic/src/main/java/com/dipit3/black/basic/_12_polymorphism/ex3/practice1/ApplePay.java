package com.dipit3.black.basic._12_polymorphism.ex3.practice1;

public class ApplePay implements Pay{

    @Override
    public boolean pay(int amount){
        System.out.println("애플페이 시스템과 연결합니다.");
        System.out.println(amount+"원 결제를 시도합니다.");
        return true;
    }
}
