package org.example.failed.chainOfResponsibility;

import org.example.strategyAndFactory.factoryChild.PaymentDetailFactory;

public interface PaymentFactory {
    PaymentDetailFactory getPayment(String Type);
}
