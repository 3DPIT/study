package black.demo.discount;

import black.demo.member.Member;

public interface DiscountPolicy {
    int discount (Member member, int price);
}
