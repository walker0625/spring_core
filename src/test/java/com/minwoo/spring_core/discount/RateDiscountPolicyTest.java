package com.minwoo.spring_core.discount;

import com.minwoo.spring_core.member.Grade;
import com.minwoo.spring_core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Vip는 10프로 할인")
    void vip_o() {
        //given
        Member vipMember = new Member(1L, "VipMember", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(vipMember, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("Vip만 10프로 할인")
    void vip_x() {
        //given
        Member member = new Member(1L, "VipMember", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}