package com.danny.quizworld.question.keyword;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeywordStore {

    private final KeywordRepository keywordRepository;

    public void save(Keyword keyword) {
        keywordRepository.save(keyword);
    }
}
