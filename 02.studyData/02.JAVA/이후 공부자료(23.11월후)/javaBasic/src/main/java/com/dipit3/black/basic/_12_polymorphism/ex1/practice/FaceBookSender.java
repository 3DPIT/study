package com.dipit3.black.basic._12_polymorphism.ex1.practice;

public class FaceBookSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("페이스북에 발송합니다 :"+message);
    }
}
