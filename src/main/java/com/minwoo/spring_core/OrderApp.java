package com.minwoo.spring_core;

import com.minwoo.spring_core.member.Grade;
import com.minwoo.spring_core.member.Member;
import com.minwoo.spring_core.member.MemberService;
import com.minwoo.spring_core.member.MemberServiceImpl;
import com.minwoo.spring_core.order.Order;
import com.minwoo.spring_core.order.OrderService;
import com.minwoo.spring_core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item1", 10000);

        System.out.println(order);
        System.out.println(order.calculatePrice());
    }
}
