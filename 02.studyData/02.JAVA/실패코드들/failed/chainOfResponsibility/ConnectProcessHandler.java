package org.example.failed.chainOfResponsibility;

import org.example.factory3.concreateFactory.PaymentMainFactory;

public class ConnectProcessHandler extends RequestHandler{
    public ConnectProcessHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(PaymentMainFactory paymentFactory, String type) {
        System.out.println("Payment Service에 접속하였습니다.");
        System.out.println(type+ "통신이 시작되었습니다.");

        super.handle(paymentFactory,type);
    }
}
