package org.example.strategyAndFactory.factoryChild;


import org.example.strategyAndFactory.concreate.Payment;

public class CreditCardPayment implements PaymentDetailFactory {

//    private Payment paymentStrategy;
//
//    public CreditCardPayment(Payment paymentStrategy) {
//        this.paymentStrategy = paymentStrategy;
//    }

    @Override
    public Payment getPayment(Payment paymentStrategy) {
        System.out.println("카드 통신이 시작되었습니다.");
        System.out.println("결제 처리중 상태를 체크 하고 있습니다...");
        System.out.println("카드사 통신이 정상 상태 입니다");
        return paymentStrategy;
    }
}
