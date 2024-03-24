package org.example.factory2.concreteBankTransfer;

import org.example.factory2.BankTransfer;

public class AccountTransferPayment implements BankTransfer {
    @Override
    public void bill() {
        System.out.println("계좌이체");
    }
}
