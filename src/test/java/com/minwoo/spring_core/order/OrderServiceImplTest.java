package com.minwoo.spring_core.order;

import com.minwoo.spring_core.AppConfig;
import com.minwoo.spring_core.member.Grade;
import com.minwoo.spring_core.member.Member;
import com.minwoo.spring_core.member.MemberService;
import com.minwoo.spring_core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OrderServiceImplTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item1", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isNotEqualTo(1000);
    }

}