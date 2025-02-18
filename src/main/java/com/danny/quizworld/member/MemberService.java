package com.danny.quizworld.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final MemberMapper memberMapper;

    @Transactional
    public Member save(Member member){
        return memberStore.save(member);
    }

    @Transactional
    public Member findByLoginId(String loginId) {
        return memberReader.findByLoginId(loginId);
    }

    @Transactional(readOnly = true)
    public Member findById(Long memberId) {
        return memberReader.findById(memberId);
    }

    public Member toEntity(MemberSaveRequest request){
        return memberMapper.toEntity(request);
    }

    public MemberResponse toResponse(Member member){
        return memberMapper.toResponse(member);
    }


}
