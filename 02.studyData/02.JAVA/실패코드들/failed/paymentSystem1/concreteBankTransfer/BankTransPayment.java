package org.example.factory2.concreteBankTransfer;

import org.example.factory2.BankTransfer;

public class BankTransPayment implements BankTransfer {
    @Override
    public void bill() {
        System.out.println("무통장입금");
    }
}
