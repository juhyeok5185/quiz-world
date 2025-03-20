package com.danny.quizworld.quiz.keyword;

import com.danny.quizworld.common.config.MyException;
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
