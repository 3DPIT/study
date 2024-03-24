package org.example.failed.factory4.stratgy;

public class Payment implements Strategy {
    @Override
    public void card() {
        System.out.println("카드로 결제");
    }

    @Override
    public void cash() {
        System.out.println("현금으로 결제");
    }
}
