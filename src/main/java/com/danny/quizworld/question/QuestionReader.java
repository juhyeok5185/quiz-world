package com.danny.quizworld.question;

import com.danny.quizworld.common.config.MyException;
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

    public Question findById(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new MyException("문제를 찾을 수 없습니다."));
    }
}
