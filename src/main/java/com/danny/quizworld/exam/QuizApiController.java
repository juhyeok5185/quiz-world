package com.danny.quizworld.exam;

import com.danny.quizworld.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quizzes")
public class QuizApiController {

    private final QuizFacade quizFacade;

    @PostMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<Long>> saveQuestion(@PathVariable Long chapterId, @ModelAttribute QuizSaveRequest request) {
        return ResponseEntity.status(201).body(new ApiResponse<>(
                "등록 완료"
                , 201
                , quizFacade.saveQuestion(chapterId, request))
        );
    }

    @GetMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<List<QuizCommonResponse>>> findAllByChapterIdToCommon(@PathVariable Long chapterId) {
        return ResponseEntity.ok(new ApiResponse<>(quizFacade.findAllByChapterIdToCommon(chapterId)));
    }

    @PatchMapping("/questions/{questionId}")
    public ResponseEntity<ApiResponse<Long>> updateQuestion(@PathVariable Long questionId, @ModelAttribute QuizUpdateRequest request) {
        quizFacade.updateQuestion(questionId, request);
        return ResponseEntity.status(201).body(new ApiResponse<>(
                "등록 완료"
                , 201
                , questionId)
        );
    }

    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<ApiResponse<Long>> deleteByQuestionId(@PathVariable Long questionId) {
        return ResponseEntity.ok(new ApiResponse<>(quizFacade.deleteByQuestionId(questionId)));
    }

    @GetMapping("/questions/{questionId}")
    public ResponseEntity<ApiResponse<QuizCommonResponse>> findByQuestionIdToResponse(@PathVariable Long questionId){
        return ResponseEntity.ok(new ApiResponse<>(quizFacade.findByQuestionIdToResponse(questionId)));
    }

}
