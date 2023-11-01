package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();

//    //private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    // 역할 구현 충실하게 분리
//    //현재 상태는 DIP 위반
//    //현재 문제는 변경되는 순간 orderServiceImpl에서 코드 변경이 또 필요하다.
//    //ocp위반, DIP 위반한 상황

    //해결 코드
    private DiscountPolicy discountPolicy; // 이렇게만 하면 null exception 생김 그래서 누군가가 따로 주입해줘야함

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
