package com.dipit3.black.basic._12_polymorphism.ex3.study;

public class DefaultPay implements Pay {

    @Override
    public boolean pay(int amount) {
        System.out.println("결제 수단이 없습니다.");
        return false;
    }
}
