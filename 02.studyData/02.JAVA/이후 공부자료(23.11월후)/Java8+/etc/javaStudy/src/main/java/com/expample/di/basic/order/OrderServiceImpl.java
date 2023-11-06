package com.expample.di.basic.order;

import com.expample.di.basic.discount.DiscountPolicy;
import com.expample.di.basic.discount.FixedDiscountPolicy;
import com.expample.di.basic.member.Member;
import com.expample.di.basic.member.MemberRepository;
import com.expample.di.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);
    }
}
