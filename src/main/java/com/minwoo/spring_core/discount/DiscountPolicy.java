package com.minwoo.spring_core.discount;

import com.minwoo.spring_core.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
