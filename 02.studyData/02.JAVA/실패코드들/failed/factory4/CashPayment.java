package org.example.failed.factory4;

import org.example.failed.factory4.concreate.Card;
import org.example.failed.factory4.concreate.Cash;
import org.example.failed.factory4.concreate.Payment;

public class CashPayment implements PaymentDetailFactory {

    @Override
    public Payment getPayment(String Type) {
       if(Type.equals("Card")){
           return new Card();
       }else if(Type.equals("Npay")){
           return new Cash();
       }

       return null;
    }
}
