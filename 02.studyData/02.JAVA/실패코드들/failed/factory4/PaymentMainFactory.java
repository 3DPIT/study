package org.example.failed.factory4;

public class PaymentMainFactory implements PaymentFactory {

    @Override
    public PaymentDetailFactory getPayment(String Type) {
        if(Type.equals("Card")) {
            return new CashPayment();
        }else if(Type.equals("Npay")) {
            return new CashPayment();
        }

        return null;
    }
}
