package com.danny.quizworld.question;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.question.keyword.KeywordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionApiController {

    private final QuestionFacade questionFacade;

    @PostMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<Long>> saveShortType(@PathVariable Long chapterId, QuestionSaveRequest request) {
        return ResponseEntity.status(201).body(new ApiResponse<>(
                "등록 완료"
                , 201
                , questionFacade.saveQuestion(chapterId, request))
        );
    }

    @GetMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<List<QuestionCommonResponse>>> findAllByChapterIdToCommon(@PathVariable Long chapterId) {
        return ResponseEntity.ok(new ApiResponse<>(questionFacade.findAllByChapterIdToCommon(chapterId)));
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<ApiResponse<Long>> deleteByQuestionId(@PathVariable Long questionId) {
        return ResponseEntity.ok(new ApiResponse<>(questionFacade.deleteByQuestionId(questionId)));
    }

    @DeleteMapping("/keywords/{keywordId}")
    public ResponseEntity<ApiResponse<Long>> deleteByKeywordId(@PathVariable Long keywordId) {
        return ResponseEntity.status(200).body(new ApiResponse<>(
                "삭제 완료"
                , 200
                , questionFacade.deleteKeyword(keywordId))
        );
    }

    @DeleteMapping("/{questionId}/keywords")
    public ResponseEntity<ApiResponse<Long>> deleteKeywordByQuestionId(@PathVariable Long questionId , KeywordRequest request) {
        return ResponseEntity.status(201).body(new ApiResponse<>(
                "등록 완료"
                , 201
                , questionFacade.saveKeyword(questionId , request))
        );
    }


}
