package black.demo.discount;

import black.demo.member.Grade;
import black.demo.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 2000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
