package com.dipit3.black.basic._12_polymorphism.ex2.practice1;

public class KmPay implements Pay {

    @Override
    public boolean pay(int amount){
        System.out.println("KM 시스템과 연결합니다.");
        System.out.println(amount + "원 결제를 시도합니다.");
        return true;
    }
}
