package com.dipit3.black.basic._12_polymorphism.ex3.study;

public abstract class PayStore {
    public static Pay findPay(String option){
        if(option.equals("kakao")){
            return new KakaoPay();
        }else if(option.equals("naver")) {
            return new NaverPay();
        }else if(option.equals("newPay")) {
            return new NewPay();
        }else{
            return new DefaultPay();
//            System.out.println("결제 수단이 없습니다.");
//            return null;
        }
    }
}
