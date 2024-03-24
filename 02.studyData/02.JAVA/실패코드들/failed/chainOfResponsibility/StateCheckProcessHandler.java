package org.example.failed.chainOfResponsibility;

import org.example.factory3.concreateFactory.PaymentMainFactory;

public class StateCheckProcessHandler extends RequestHandler{
    public StateCheckProcessHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(PaymentMainFactory paymentFactory, String type){
        System.out.println("++++++++++");
        System.out.println("결제 처리중 상태를 체크 하고 있습니다...");
        System.out.println(type+" 통신이 정상 상태 입니다.");
        System.out.println("++++++++++");
        super.handle(paymentFactory, type);
    }
}
