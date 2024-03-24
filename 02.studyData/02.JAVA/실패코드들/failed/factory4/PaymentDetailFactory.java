package org.example.failed.factory4;

import org.example.failed.factory4.concreate.Payment;

public interface PaymentDetailFactory{
    Payment getPayment(String Type);
}
