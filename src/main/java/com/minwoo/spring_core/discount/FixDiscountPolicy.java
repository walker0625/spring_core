package com.minwoo.spring_core.discount;

import com.minwoo.spring_core.member.Grade;
import com.minwoo.spring_core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary // @Qualifier가 우선순위가 더 높음
@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
