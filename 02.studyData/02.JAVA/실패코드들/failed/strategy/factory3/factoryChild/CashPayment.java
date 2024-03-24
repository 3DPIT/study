package org.example.failed.strategy.factory3.factoryChild;

import lombok.NoArgsConstructor;
import org.example.factory3.concreate.Payment;

@NoArgsConstructor
public class CashPayment implements PaymentDetailFactory {
    private Payment paymentStrategy;

    public void setCashPayment(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public Payment getPayment(String type) {
        System.out.println(type + "으로 결제를 진행합니다.");
        return this.paymentStrategy;
    }
}
