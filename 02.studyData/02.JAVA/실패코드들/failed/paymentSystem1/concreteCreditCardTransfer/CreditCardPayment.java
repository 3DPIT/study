package org.example.factory2.concreteCreditCardTransfer;

import org.example.factory2.CreditCardTransfer;

public class CreditCardPayment implements CreditCardTransfer {

    @Override
    public void bill() {
        System.out.println("신용카드결제");
    }
}
