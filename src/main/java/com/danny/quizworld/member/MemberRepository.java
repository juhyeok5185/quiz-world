package com.danny.quizworld.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member , Long> {
    Member findByAuthId(String authId);

    List<Member> findAllBySubscribeYnTrue();

    Long countByNickname(String nickname);

}
