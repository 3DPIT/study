package org.example.failed.strategy.factory3.concreate;

public class NoBank implements Payment {

    @Override
    public void pay(int money) {
        System.out.println(money+"무통장으로 지불");
    }
}
