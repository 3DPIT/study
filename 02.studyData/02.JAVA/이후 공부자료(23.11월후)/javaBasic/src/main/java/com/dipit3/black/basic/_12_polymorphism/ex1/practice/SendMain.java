package com.dipit3.black.basic._12_polymorphism.ex1.practice;

/**
 * Created by black on 2024-05-29
 */
public class SendMain {
    public static void main(String[] args) {
        Sender[] senders = {new EmailSender(), new SmsSender(), new FaceBookSender()};
        for(Sender sender : senders){
            sender.sendMessage("환영합니다!");
        }



/* 실행결과
메일을 발송합니다: 환영합니다!
SMS를 발송합니다: 환영합니다!
페이스북에 발송합니다: 환영합니다!
 */

/* 요구사항
다형성 활용
Sender인터페이스 사용
EmailSender, SmsSender, FaceBookSender 클래스 구현
 */
    }
}

