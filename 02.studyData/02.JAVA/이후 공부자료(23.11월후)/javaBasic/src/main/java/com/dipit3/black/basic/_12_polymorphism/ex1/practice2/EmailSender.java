package com.dipit3.black.basic._12_polymorphism.ex1.practice2;

public class EmailSender implements Sender{
    @Override
    public void sendMessage(String message) {
        System.out.println("메일을 발송합니다: "+message);
    }
}
