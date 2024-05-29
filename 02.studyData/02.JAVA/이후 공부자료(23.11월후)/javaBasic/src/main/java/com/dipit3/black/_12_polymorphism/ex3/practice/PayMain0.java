package com.dipit3.black._12_polymorphism.ex3.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayMain0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PayService payService = new PayService();

        while(true) {
            System.out.print("결제 수단을 입력하세요: ");
            String option = br.readLine();

            if(option.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            System.out.print("결제 금액을 입력하세요: ");
            String amount = br.readLine();

            payService.processPay(option, Integer.parseInt(amount));
        }
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

