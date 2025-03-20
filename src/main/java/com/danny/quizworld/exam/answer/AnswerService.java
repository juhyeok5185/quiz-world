package com.danny.quizworld.exam.answer;

import com.danny.quizworld.exam.question.Question;
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

    public void deleteAll(List<Answer> answerList) {
        answerStore.deleteAll(answerList);
    }
}
