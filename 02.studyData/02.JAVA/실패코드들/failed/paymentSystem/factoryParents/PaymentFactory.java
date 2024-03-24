package org.example.strategyAndFactory.factoryParents;


import org.example.strategyAndFactory.factoryChild.PaymentDetailFactory;

public interface PaymentFactory {
    PaymentDetailFactory getPaymentMethod(PaymentDetailFactory paymentDetailFactory);
}
