package com.danny.quizworld.exam;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.exam.answer.Answer;
import com.danny.quizworld.exam.answer.AnswerResponse;
import com.danny.quizworld.exam.answer.AnswerService;
import com.danny.quizworld.exam.question.*;
import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizFacade {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ChapterService chapterService;

    @Transactional
    public Long saveQuestion(Long chapterId, QuizSaveRequest request) {
        Chapter chapter = chapterService.findById(chapterId);
        Question question = questionService.save(questionService.toEntity(chapter, request.getQuestionRequest()));
        request.getAnswerRequest().forEach(answerRequest -> {
            Answer answer = answerService.toEntity(question, answerRequest);
            answerService.save(answer);
        });
//        if (request.getKeywordRequest() != null) {
//            request.getKeywordRequest().forEach(keywordRequest -> {
//                Keyword keyword = keywordService.toEntity(question, keywordRequest.getName());
//                keywordService.save(keyword);
//            });
//        }

        return question.getQuestionId();
    }

    @Transactional
    public Long deleteByQuestionId(Long questionId) {
        Question question = questionService.findById(questionId);
        List<Answer> answerList = answerService.findAllByQuestionId(questionId);
        answerList.forEach(BaseTimeEntity::updateUseYn);
        question.updateUseYn();
        return questionId;
    }

    @Transactional(readOnly = true)
    public List<QuizCommonResponse> findAllByChapterIdToCommon(Long chapterId) {
        List<QuizCommonResponse> quizCommonResponseList = new ArrayList<>();
        List<QuestionResponse> questionResponseList = findAllQuestionByChapterIdToResponse(chapterId);
        questionResponseList.forEach(questionResponse -> {
            List<AnswerResponse> answerResponseList = findAllAnswerByChapterIdToResponse(questionResponse.getQuestionId());
            QuizCommonResponse quizCommonResponse = new QuizCommonResponse(questionResponse, answerResponseList);
            quizCommonResponseList.add(quizCommonResponse);
        });
        return quizCommonResponseList;
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
    public QuizCommonResponse findByQuestionIdToResponse(Long questionId) {
        QuestionResponse question = questionService.toResponse(questionService.findById(questionId));
        List<AnswerResponse> answerResponseList = findAllAnswerByChapterIdToResponse(questionId);
        return new QuizCommonResponse(question, answerResponseList);
    }

    @Transactional
    public void updateQuestion(Long questionId, QuizUpdateRequest request) {
        Question question = questionService.findById(questionId);
//        question.updateByUpdateRequest(request.getQuestionRequest());
        questionService.save(question);

        List<Answer> answerList = answerService.findAllByQuestionId(questionId);
        answerService.deleteAll(answerList);
        request.getAnswerRequest().forEach(answerRequest -> {
            Answer answer = answerService.toEntity(question, answerRequest);
            answerService.save(answer);
        });
    }
}
