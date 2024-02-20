package com.cis.batch33.library.service;

import com.cis.batch33.library.model.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MemberService {

    private Map<Long, Member> memberMap = new HashMap<>();

    public Member createMember(Member member) {
        Long memberId = new Random().nextLong();
        member.setMemberId(memberId);
        memberMap.put(memberId, member);
        return member;
    }

    public Member getMember(Long memberId) {
        return memberMap.get(memberId);
    }

    public Member updateMember(Long memberId, Member updatedMember) {
        if (memberMap.containsKey(memberId)) {
            Member existingMember = memberMap.get(memberId);
            existingMember.setFirstName(updatedMember.getFirstName());
            existingMember.setEmailAddress(updatedMember.getEmailAddress());
            return existingMember;
        } else {
            // Handle the case where memberId is not found, for example, throw an exception
            throw new IllegalArgumentException("Member with ID " + memberId + " not found");
        }
    }

    public boolean deleteMember(Long memberId) {
        memberMap.remove(memberId);
        return false;
    }
}
