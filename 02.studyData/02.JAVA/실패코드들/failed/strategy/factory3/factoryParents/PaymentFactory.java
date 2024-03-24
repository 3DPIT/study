package org.example.failed.strategy.factory3.factoryParents;

import org.example.failed.strategy.factory3.factoryChild.PaymentDetailFactory;

public interface PaymentFactory {
    PaymentDetailFactory getPayment(String type);
}
