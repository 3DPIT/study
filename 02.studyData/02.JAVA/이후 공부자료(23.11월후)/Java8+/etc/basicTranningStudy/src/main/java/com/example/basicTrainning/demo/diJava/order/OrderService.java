package com.example.basicTrainning.demo.diJava.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
