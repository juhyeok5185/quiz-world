package com.danny.quizworld.quiz.keyword;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeywordStore {

    private final KeywordRepository keywordRepository;

    public void save(Keyword keyword) {
        keywordRepository.save(keyword);
    }

    public void deleteById(Long keywordId) {
        keywordRepository.deleteById(keywordId);
    }
}
