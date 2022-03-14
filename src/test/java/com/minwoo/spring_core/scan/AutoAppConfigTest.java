package com.minwoo.spring_core.scan;

import com.minwoo.spring_core.AutoAppConfig;
import com.minwoo.spring_core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService bean = annotationConfigApplicationContext.getBean(MemberService.class);

        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
    }

}
