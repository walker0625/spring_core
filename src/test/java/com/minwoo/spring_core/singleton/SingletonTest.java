package com.minwoo.spring_core.singleton;

import com.minwoo.spring_core.AppConfig;
import com.minwoo.spring_core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void pureContainer() {
        AppConfig ac = new AppConfig();

        MemberService m1 = ac.memberService();
        MemberService m2 = ac.memberService();

        System.out.println(m1);
        System.out.println(m2);

        assertThat(m1).isNotSameAs(m2);
    }

    @Test
    void singletonTest() {
        SingletonService ss = SingletonService.getInstance();
        SingletonService ss2 = SingletonService.getInstance();

        assertThat(ss).isEqualTo(ss2); // 값 비교
        assertThat(ss).isSameAs(ss2); // instance 비교
    }

    @Test
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService m1 = ac.getBean("memberService", MemberService.class);
        MemberService m2 = ac.getBean("memberService", MemberService.class);

        System.out.println(m1);
        System.out.println(m2);

        assertThat(m1).isSameAs(m2);
    }

}
