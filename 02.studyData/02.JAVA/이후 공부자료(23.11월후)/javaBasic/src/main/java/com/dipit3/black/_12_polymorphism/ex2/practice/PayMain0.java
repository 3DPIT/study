package com.dipit3.black._12_polymorphism.ex2.practice;

public class PayMain0 {
    public static void main(String[] args) {
        PayService payService = new PayService();

        //kakao 결제
        String payOption1 = "kakao";
        int amount1 = 5000;
        payService.processPay(payOption1, amount1);

        //naver 결제
        String payOption2 = "naver";
        int amount2 = 10000;
        payService.processPay(payOption2, amount2);

        //잘못된 결제 수단 선택
        String payOption3 = "bad";
        int amount3 = 15000;
        payService.processPay(payOption3, amount3);

//        //새로운 페이 추가
//        String payOption4 = "newPay";
//        int amount4 = 25000;
//        payService.processPay(payOption4, amount4);
    }
}
/* 실행결과
결제를 시작합니다: option=kakao, amount=5000 카카오페이 시스템과 연결합니다.
5000원 결제를 시도합니다.
결제가 성공했습니다.
결제를 시작합니다: option=naver, amount=10000 네이버페이 시스템과 연결합니다.
10000원 결제를 시도합니다.
결제가 성공했습니다.
결제를 시작합니다: option=bad, amount=15000 결제 수단이 없습니다.
결제가 실패했습니다.
 */

/*요구사항
OCP 원칙을 지키세요.
메서드를 포함한 모든 코드를 변경해도 됩니다. 클래스나 인터페이스를 추가해도 됩니다.
단 프로그램을 실행하는 `PayMain0` 코드는 변경하지 않고, 그대로 유지해야 합니다.
리펙토링 후에도 실행 결과는 기존과 같아야 합니다.
 */

