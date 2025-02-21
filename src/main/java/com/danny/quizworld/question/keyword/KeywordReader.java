package com.danny.quizworld.question.keyword;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeywordReader {

    private final KeywordRepository keywordRepository;

    public Keyword findById(Long keywordId) {
        return keywordRepository.findById(keywordId).orElseThrow(() -> new MyException("키워드를 찾을 수 없습니다."));
    }
}
