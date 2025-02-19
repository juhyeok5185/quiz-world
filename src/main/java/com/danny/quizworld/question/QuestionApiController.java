package com.danny.quizworld.question;

import com.danny.quizworld.common.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<Long>> saveShort(@PathVariable Long chapterId, QuestionShortTypeSaveRequest request) {
        return ResponseEntity.status(201).body(new ApiResponse<>(
                "등록 완료"
                , 201
                , questionFacade.save(chapterId,request))
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
}
