package com.danny.quizworld.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberStore {

    private final MemberRepository memberRepository;

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }
}
