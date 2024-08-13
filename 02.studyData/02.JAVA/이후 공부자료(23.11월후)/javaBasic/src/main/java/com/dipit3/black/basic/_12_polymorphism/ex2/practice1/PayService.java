package com.dipit3.black.basic._12_polymorphism.ex2.practice1;

import static com.dipit3.black.basic._12_polymorphism.ex2.practice1.PayStore.findPay;

public class PayService {

    public void processPay(String option, int amount){

        boolean result =false   ;
        System.out.println("결제를 시작합니다: option="+ option + ", amount="+ amount);

        Pay pay=findPay(option);
        result = pay.pay(amount);

        if(result){
            System.out.println("결제가 성공했습니다.");
        }
        else{
            System.out.println("결제가 실패했습니다.");
        }
    }
}
