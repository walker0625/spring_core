package com.minwoo.spring_core.order;

import com.minwoo.spring_core.annotation.MainDiscountPolicy;
import com.minwoo.spring_core.discount.DiscountPolicy;
import com.minwoo.spring_core.discount.FixDiscountPolicy;
import com.minwoo.spring_core.discount.RateDiscountPolicy;
import com.minwoo.spring_core.member.Member;
import com.minwoo.spring_core.member.MemberRepository;
import com.minwoo.spring_core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; // 필수
    private final DiscountPolicy discountPolicy;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // @Autowired 생략가능 - 불변
    /* public OrderServiceImpl(MemberRepository memberRepository,
                            //@Qualifier("mainDiscountPolicy")
                            @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
