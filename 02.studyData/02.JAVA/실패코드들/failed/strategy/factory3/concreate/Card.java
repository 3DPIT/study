package org.example.failed.strategy.factory3.concreate;

public class Card implements Payment {
    @Override
    public void pay(int money) {
        System.out.println(money+"카드로 지불");
    }
}
