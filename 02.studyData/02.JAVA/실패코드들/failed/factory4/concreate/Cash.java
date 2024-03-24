package org.example.failed.factory4.concreate;

public class Cash implements Payment {

    @Override
    public void pay(int money) {
        System.out.println(money + "현금으로 지불");

    }
}
