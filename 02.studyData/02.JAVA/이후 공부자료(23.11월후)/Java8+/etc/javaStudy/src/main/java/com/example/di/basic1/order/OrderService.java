package com.example.di.basic1.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
