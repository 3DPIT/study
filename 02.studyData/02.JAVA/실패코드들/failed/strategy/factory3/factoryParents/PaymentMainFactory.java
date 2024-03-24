package org.example.failed.strategy.factory3.factoryParents;

import lombok.NoArgsConstructor;
import org.example.failed.strategy.factory3.factoryChild.PaymentDetailFactory;

@NoArgsConstructor
public class PaymentMainFactory implements PaymentFactory {

    private PaymentDetailFactory paymentDetailFactory;

    public void setPaymentMainFactory(PaymentDetailFactory paymentDetailFactory) {
        this.paymentDetailFactory = paymentDetailFactory;
    }
    @Override
    public PaymentDetailFactory getPayment(String type ) {

        return  this.paymentDetailFactory;
    }
}

