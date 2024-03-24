package org.example.failed.factory4;

import org.example.failed.factory4.concreate.Bank;
import org.example.failed.factory4.concreate.NoBank;
import org.example.failed.factory4.concreate.Payment;

public class CreditCardPayment implements PaymentDetailFactory {

    @Override
    public Payment getPayment(String Type) {
        if (Type.equals("Bank")) {
            return new Bank();
        } else if (Type.equals("NoBank")) {
            return new NoBank();
        }

        return null;
    }
}
