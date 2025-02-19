package com.danny.quizworld.question.answer;

import com.danny.quizworld.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerReader answerReader;
    private final AnswerStore answerStore;
    private final AnswerMapper answerMapper;

    public Answer save(Answer answer){
        return answerStore.save(answer);
    }

    public List<Answer> findAllByQuestionId(Long questionId){
        return answerReader.findAllByQuestionId(questionId);
    }


    public Answer toEntity(Question question,AnswerRequest request) {
        return answerMapper.toEntity(question,request);
    }

    public AnswerResponse toResponse(Answer answer) {
        return answerMapper.toResponse(answer);
    }
}
