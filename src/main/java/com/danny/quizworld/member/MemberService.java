package com.danny.quizworld.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberStore memberStore;
    private final MemberMapper memberMapper;

    @Transactional
    public Member save(Member member){
        return memberStore.save(member);
    }

    public Member toEntity(MemberSaveRequest request){
        return memberMapper.toEntity(request);
    }

    public MemberResponse toResponse(Member member){
        return memberMapper.toResponse(member);
    }

}
