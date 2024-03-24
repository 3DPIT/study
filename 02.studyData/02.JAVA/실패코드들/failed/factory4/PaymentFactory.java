package org.example.failed.factory4;

public interface PaymentFactory {
    PaymentDetailFactory getPayment(String Type);
}
