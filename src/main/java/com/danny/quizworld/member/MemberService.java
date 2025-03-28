package com.danny.quizworld.member;

import com.danny.quizworld.common.response.UserDashBoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final MemberMapper memberMapper;
    private final MemberDao memberDao;

    @Transactional
    public Member save(Member member){
        return memberStore.save(member);
    }

    @Transactional(readOnly = true)
    public Member findById(Long memberId) {
        return memberReader.findById(memberId);
    }

    @Transactional(readOnly = true)
    public Member findByEmail(String email) {
        return memberReader.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<Member> findAllBySubscribeYnTrue() {
        return memberReader.findAllBySubscribeYnTrue();
    }

    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberReader.findAll();
    }
    public Member toEntity(String name , String email , String nickname){
        return memberMapper.toEntity(name ,email , nickname);
    }

    public MemberResponse toResponse(Member member){
        return memberMapper.toResponse(member);
    }


    @Transactional(readOnly = true)
    public UserDashBoardResponse findUserDashBoardResponseByMemberId(Long memberId) {
        return memberDao.findUserDashBoardResponseByMemberId(memberId);
    }
}
