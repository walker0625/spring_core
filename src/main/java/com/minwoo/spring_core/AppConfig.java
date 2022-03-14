package com.minwoo.spring_core;

import com.minwoo.spring_core.discount.DiscountPolicy;
import com.minwoo.spring_core.discount.RateDiscountPolicy;
import com.minwoo.spring_core.member.MemberService;
import com.minwoo.spring_core.member.MemberServiceImpl;
import com.minwoo.spring_core.member.MemoryMemberRepository;
import com.minwoo.spring_core.order.OrderService;
import com.minwoo.spring_core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return  new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
