package com.danny.quizworld.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionReader {

    private final QuestionRepository questionRepository;

    public List<Question> findAllByChapterId(Long chapterId) {
        return questionRepository.findAllByChapter_ChapterIdAndUseYnTrue(chapterId);
    }
}
