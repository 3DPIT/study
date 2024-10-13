package com.dipit3.black.basic._12_polymorphism.ex3.practice1;

public abstract class PayStrategy {

    public static Pay findPay(String option) {
        if(option.equals("kakao")){
            return new KakaoPay();
        }else if(option.equals("naver")){
            return new NaverPay();
        }else{
            return new DefaultPay();
        }
    }
}
