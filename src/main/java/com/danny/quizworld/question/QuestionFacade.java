package com.danny.quizworld.question;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.question.answer.Answer;
import com.danny.quizworld.question.answer.AnswerResponse;
import com.danny.quizworld.question.answer.AnswerService;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionFacade {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ChapterService chapterService;

    @Transactional
    public Long save(Long chapterId, QuestionShortTypeSaveRequest request) {
        Chapter chapter = chapterService.findById(chapterId);
        Question question = questionService.save(questionService.toEntity(chapter, request));
        Answer answer = answerService.toEntity(question, request.getAnswerRequest());
        answerService.save(answer);
        return question.getQuestionId();
    }

    @Transactional(readOnly = true)
    public List<QuestionResponse> findAllQuestionByChapterIdToResponse(Long chapterId) {
        List<Question> questionList = questionService.findAllByChapterId(chapterId);
        return questionList.stream()
                .map(questionService::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<AnswerResponse> findAllAnswerByChapterIdToResponse(Long questionId) {
        List<Answer> answerList = answerService.findAllByQuestionId(questionId);
        return answerList.stream()
                .map(answerService::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<QuestionCommonResponse> findAllByChapterIdToCommon(Long chapterId) {
        List<QuestionCommonResponse> questionCommonResponseList = new ArrayList<>();
        List<QuestionResponse> questionResponseList = findAllQuestionByChapterIdToResponse(chapterId);
        questionResponseList.forEach(questionResponse -> {
            List<AnswerResponse> answerResponseList = findAllAnswerByChapterIdToResponse(questionResponse.getQuestionId());
            QuestionCommonResponse questionCommonResponse = new QuestionCommonResponse(questionResponse, answerResponseList);
            questionCommonResponseList.add(questionCommonResponse);
        });
        return questionCommonResponseList;
    }

    @Transactional
    public Long deleteByQuestionId(Long questionId) {
        Question question = questionService.findById(questionId);
        List<Answer> answerList = answerService.findAllByQuestionId(questionId);
        answerList.forEach(BaseTimeEntity::updateUseYn);
        question.updateUseYn();
        return questionId;
    }
}
