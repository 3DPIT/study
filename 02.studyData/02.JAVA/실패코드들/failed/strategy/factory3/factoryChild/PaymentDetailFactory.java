package org.example.failed.strategy.factory3.factoryChild;

import org.example.factory3.concreate.Payment;

public interface PaymentDetailFactory {
    Payment getPayment(String Type);
}
