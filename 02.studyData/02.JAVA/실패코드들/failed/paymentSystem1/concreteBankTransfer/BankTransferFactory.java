package org.example.factory2.concreteBankTransfer;

import org.example.factory2.BankTransfer;

public class BankTransferFactory {

    public BankTransfer Start(String type){
        if(type.equals("무통장입금")){
            return new BankTransPayment();
        }else if(type.equals("계좌이체")){
            return new AccountTransferPayment();
        }
        return null;
    }
}
