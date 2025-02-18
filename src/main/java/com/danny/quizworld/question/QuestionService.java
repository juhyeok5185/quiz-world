package com.danny.quizworld.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionReader questionReader;
    private final QuestionStore questionStore;

    @Transactional
    public Question save(Question question){
        return questionStore.save(question);
    }

    @Transactional(readOnly = true)
    public List<Question> findAllByChapterId(Long chapterId){
        return questionReader.findAllByChapterId(chapterId);
    }
}
