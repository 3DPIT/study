package com.example.demoddd.order.order_before;

public enum OrderState {
    PAYMENT_WAITING{
        public boolean isShippingChangeable(){
            return true;
        }
    },
    PREPARING{
        public boolean isShippingChangeable(){
            return true;
        }
    },
    SHIOPPED, DELIBERING, DELIVERY_COMPLETED;

    public boolean isShippingChangeable(){
        return false;
    }
}
