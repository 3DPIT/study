package org.example.strategyAndFactory.factoryParents;


import org.example.strategyAndFactory.factoryChild.PaymentDetailFactory;

public class PaymentMainFactory implements PaymentFactory {

//    private PaymentDetailFactory paymentDetailFactory;
//    public PaymentMainFactory(PaymentDetailFactory paymentDetailFactory) {
//        this.paymentDetailFactory = paymentDetailFactory;
//    }
    @Override
    public PaymentDetailFactory getPaymentMethod(PaymentDetailFactory paymentDetailFactory) {
        System.out.println("payment Service에 접속 하였습니다.");
       return paymentDetailFactory;
    }
}
