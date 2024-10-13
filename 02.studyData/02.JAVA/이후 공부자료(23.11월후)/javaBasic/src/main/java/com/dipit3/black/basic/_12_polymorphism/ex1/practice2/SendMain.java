package com.dipit3.black.basic._12_polymorphism.ex1.practice2;

public class SendMain {
    public static void main(String[] args) {
        Sender[] senders = {new EmailSender(), new SmsSender(), new FaceBookSender()};

        for(Sender sender : senders){
            sender.sendMessage("환영합니다!");
        }
    }
}
