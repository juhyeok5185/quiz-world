package com.danny.quizworld.question.keyword;

import com.danny.quizworld.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KeywordService {
    private final KeywordReader keywordReader;
    private final KeywordStore keywordStore;
    private final KeywordMapper keywordMapper;

    @Transactional
    public void save(Keyword keyword){
        keywordStore.save(keyword);
    }


    public Keyword toEntity(Question question, String name) {
        return keywordMapper.toEntity(question, name);
    }

    public Keyword findById(Long keywordId) {
        return keywordReader.findById(keywordId);
    }

    public void deleteById(Long keywordId) {
        keywordStore.deleteById(keywordId);
    }
}
