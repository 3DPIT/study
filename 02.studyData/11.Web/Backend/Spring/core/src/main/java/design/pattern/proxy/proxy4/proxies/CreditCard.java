package design.pattern.proxy.proxy4.proxies;

import design.pattern.proxy.proxy4.Payment;
import design.pattern.proxy.proxy4.proxies.Cash;

public class CreditCard implements Payment {

    Payment cash = new Cash();
    @Override
    public void pay(int amount) {
        if(amount>=100) {
            System.out.printf(amount + "신용카드\n");
        }else {
            cash.pay(amount);
        }
    }
}
