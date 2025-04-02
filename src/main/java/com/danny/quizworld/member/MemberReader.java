package com.danny.quizworld.member;

import com.danny.quizworld.common.config.MyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberReader {

    private final MemberRepository memberRepository;

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new MyException("회원을 찾을 수 없습니다."));
    }

    public Member findByAuthId(String authId) {
        return memberRepository.findByAuthId(authId);
    }

    public List<Member> findAllBySubscribeYnTrue() {
        return memberRepository.findAllBySubscribeYnTrue();
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Long countByNickname(String nickname) {
        return memberRepository.countByNickname(nickname);
    }
}
