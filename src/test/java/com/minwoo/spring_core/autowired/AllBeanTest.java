package com.minwoo.spring_core.autowired;

import com.minwoo.spring_core.AutoAppConfig;
import com.minwoo.spring_core.discount.DiscountPolicy;
import com.minwoo.spring_core.member.Grade;
import com.minwoo.spring_core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService bean = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "USER1", Grade.VIP);
        int discountPrice = bean.discount(member, 10000, "fixDiscountPolicy");
        assertThat(bean).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int ratePrice  = bean.discount(member,20000, "rateDiscountPolicy");
        assertThat(ratePrice).isEqualTo(2000);
    }

    static class DiscountService {
        private final Map<String, DiscountPolicy> discountPolicyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> discountPolicyMap, List<DiscountPolicy> policyList) {
            this.discountPolicyMap = discountPolicyMap;
            this.policyList = policyList;
            System.out.println("discountMap : " + discountPolicyMap);
            System.out.println("discountList : " + policyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = discountPolicyMap.get(discountCode);
            return discountPolicy.discount(member,price);

        }
    }

}
