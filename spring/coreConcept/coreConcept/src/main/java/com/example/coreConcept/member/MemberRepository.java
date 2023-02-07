package com.example.coreConcept.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemberRepository {
    //얘는 생성되는 위치가 DependencyConfig임..
    //여기 생성자는 그냥 신경도 안썼네.

    private static Map<Long, Member> members = new HashMap<>();

    public void postMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Member getMember(Long memberId) {
        return members.get(memberId);
    }

    public void deleteMember(Long memberId) {
        members.remove(memberId);
    }
}
