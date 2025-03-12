package com.danny.quizworld.question;

import com.danny.quizworld.common.entity.BaseTimeEntity;
import com.danny.quizworld.question.answer.Answer;
import com.danny.quizworld.question.answer.AnswerResponse;
import com.danny.quizworld.question.answer.AnswerService;
import com.danny.quizworld.question.keyword.Keyword;
import com.danny.quizworld.question.keyword.KeywordRequest;
import com.danny.quizworld.question.keyword.KeywordService;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
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
    private final KeywordService keywordService;

    @Transactional
    public Long saveQuestion(Long chapterId, QuestionSaveRequest request) {
        Chapter chapter = chapterService.findById(chapterId);
        Question question = questionService.save(questionService.toEntity(chapter, request.getQuestionRequest()));
        request.getAnswerRequest().forEach(answerRequest -> {
            Answer answer = answerService.toEntity(question, answerRequest);
            answerService.save(answer);
        });
        if (request.getKeywordRequest() != null) {
            request.getKeywordRequest().forEach(keywordRequest -> {
                Keyword keyword = keywordService.toEntity(question, keywordRequest.getName());
                keywordService.save(keyword);
            });
        }

        return question.getQuestionId();
    }

    @Transactional
    public Long saveKeyword(Long questionId, KeywordRequest request) {
        Question question = questionService.findById(questionId);
        Keyword keyword = keywordService.toEntity(question, request.getName());
        keywordService.save(keyword);
        return keyword.getKeywordId();
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

    @Transactional
    public Long deleteKeyword(Long keywordId) {
        keywordService.deleteById(keywordId);
        return keywordId;
    }


    @Transactional(readOnly = true)
    public QuestionCommonResponse findByQuestionIdToResponse(Long questionId) {
        QuestionResponse question = questionService.toResponse(questionService.findById(questionId));
        List<AnswerResponse> answerResponseList = findAllAnswerByChapterIdToResponse(questionId);
        return new QuestionCommonResponse(question, answerResponseList);
    }

    @Transactional
    public void updateQuestion(Long questionId, QuestionUpdateRequest request) {
        Question question = questionService.findById(questionId);
        question.updateByUpdateRequest(request.getQuestionRequest());
        questionService.save(question);

        //todo 시험기능이 생기면 찾아서 수정해야할수도있음
        List<Answer> answerList = answerService.findAllByQuestionId(questionId);
        answerService.deleteAll(answerList);
        request.getAnswerRequest().forEach(answerRequest -> {
            Answer answer = answerService.toEntity(question, answerRequest);
            answerService.save(answer);
        });
    }
}
