package com.minwoo.spring_core;

import com.minwoo.spring_core.member.Grade;
import com.minwoo.spring_core.member.Member;
import com.minwoo.spring_core.member.MemberService;
import com.minwoo.spring_core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        memberService.join(new Member(1L, "memberA", Grade.VIP));

        System.out.println(memberService.findMember(1L).getName());
    }
}
