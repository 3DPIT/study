package org.example.strategyAndFactory.concreate;

public class Card implements Payment {
    @Override
    public void pay(int money) {
        System.out.println(money + "원이 카드로 처리되었습니다.");
        System.out.println("카드사 통신이 정상 종료 되었습니다");
        System.out.println("결제가 최종 마무리 되었습니다…");
    }
}
