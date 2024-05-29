package com.dipit3.black._12_polymorphism.ex3.study;

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
결제 수단을 입력하세요:kakao
결제 금액을 입력하세요:5000
결제를 시작합니다: option=kakao, amount=5000
카카오페이 시스템과 연결합니다.
5000원 결제를 시도합니다.
결제가 성공했습니다.
결제 수단을 입력하세요:exit
프로그램을 종료합니다.
 */

/*요구사항
입력 받을 수 잇게 수정하기
 */

