package org.example.failed.factory4.concreate;

public class NoBank implements Payment {

    @Override
    public void pay(int money) {
        System.out.println(money+"무통장으로 지불");
    }
}
