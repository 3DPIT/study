package org.example.strategyAndFactory.concreate;

public class Bank implements Payment {
    @Override
    public void pay(int money) {
        System.out.println(money + "원이 통장으로 처리되었습니다.");
        System.out.println("은행 통신이 정상 종료 되었습니다");
        System.out.println("결제가 최종 마무리 되었습니다…");
    }
}
