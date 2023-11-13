package com.example.di.basic1.order;

import com.example.di.basic1.discount.DiscountPolicy;
import com.example.di.basic1.discount.FixedDiscountPolicy;
import com.example.di.basic1.member.Member;
import com.example.di.basic1.member.MemberRepository;
import com.example.di.basic1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName, itemPrice, discountPrice);
    }
}
