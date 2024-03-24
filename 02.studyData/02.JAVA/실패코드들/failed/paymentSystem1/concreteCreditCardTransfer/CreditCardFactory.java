package org.example.factory2.concreteCreditCardTransfer;

import org.example.factory2.CreditCardTransfer;

public class CreditCardFactory {

    public CreditCardTransfer Start(String type){
        if(type.equals("간편결제")){
            return new EasyPayment();
        }else if(type.equals("신용카드 결제")){
            return new CreditCardPayment();
        }

        return null;
    }
}
