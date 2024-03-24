package org.example.failed.factory4.concreate;

public class Bank implements Payment {
    @Override
    public void pay(int money) {
        System.out.println(money+"은행에서 지불");
    }
}
