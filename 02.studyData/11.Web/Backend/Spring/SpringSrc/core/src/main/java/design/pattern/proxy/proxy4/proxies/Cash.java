package design.pattern.proxy.proxy4.proxies;

import design.pattern.proxy.proxy4.Payment;

public class Cash implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println(amount+"현금 결제\n");
    }
}
