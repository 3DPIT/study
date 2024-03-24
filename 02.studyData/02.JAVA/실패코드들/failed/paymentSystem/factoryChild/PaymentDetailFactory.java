package org.example.strategyAndFactory.factoryChild;


import org.example.strategyAndFactory.concreate.Payment;

public interface PaymentDetailFactory{
    Payment getPayment(Payment paymentStrategy);
}
