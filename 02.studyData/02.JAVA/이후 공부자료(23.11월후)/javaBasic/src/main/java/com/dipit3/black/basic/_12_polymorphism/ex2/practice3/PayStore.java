package com.dipit3.black.basic._12_polymorphism.ex2.practice3;

public class PayStore {

    public static Pay findPay(String option){
        if(option.equals("kakao")){
            return new KakaoPay();
        } else if(option.equals("naver")) {
            return new NaverPay();
        }else if(option.equals("km")) {
            return new KmPay();
        } else{
            return new DefaultPay();
        }
    }
}
