package com.minwoo.spring_core.autowired;

import com.minwoo.spring_core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member1 bean!"+ member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member2 bean!" + member);
        }

        @Autowired
        public void setNoBean2(Optional<Member> member) {
            System.out.println("member3 bean!" + member);
        }
    }
}
