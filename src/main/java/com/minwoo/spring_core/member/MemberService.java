package com.minwoo.spring_core.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
