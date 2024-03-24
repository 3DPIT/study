package org.example.failed.chainOfResponsibility;

import org.example.factory3.concreateFactory.PaymentMainFactory;

public class FinishProcessHandler extends RequestHandler{
    public FinishProcessHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(PaymentMainFactory paymentFactory, String type) {
        System.out.println("FinishProcessHandler");
        System.out.println(paymentFactory.getPayment(type) + "원이" + type+ "처리 되었습니다.");
        super.handle(paymentFactory,type);
    }
}

// 이렇게 3개의 다른 Factory가 연결

//payment Service에 접속 하였습니다. //1. I PaymentMainFactory
//카드사 통신이 시작 되었습니다.

//결제 처리중 상태를 체크 하고 있습니다... //2. I PaymentDetailFactory
//카드사 통신이 정상 상태 입니다

//1000원이 카카오 페이 처리 되었습니다. //3. I Payment
//카드사 통신이 정상 종료 되었습니다
//결제가 최종 마무리 되었습니다...
