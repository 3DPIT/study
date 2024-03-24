package org.example.failed.strategy.factory3.factoryChild;

import lombok.NoArgsConstructor;
import org.example.factory3.concreate.Payment;

@NoArgsConstructor
public class CreditCardPayment implements PaymentDetailFactory {

    private Payment paymentStrategy;
    public void setCreditCardPayment(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    @Override
    public Payment getPayment(String type) {
        System.out.println(type + "인 현금으로 결제를 진행합니다.");
        return  paymentStrategy;
    }
}
