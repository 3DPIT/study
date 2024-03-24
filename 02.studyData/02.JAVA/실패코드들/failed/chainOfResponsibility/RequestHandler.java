package org.example.failed.chainOfResponsibility;

import org.example.factory3.concreateFactory.PaymentMainFactory;

public abstract class RequestHandler {
    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handle(PaymentMainFactory paymentFactory, String type){
        if(nextHandler != null){

            nextHandler.handle(paymentFactory, type);
        }
    }
}
