package com.danny.quizworld.course.chapter;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.CourseFacade;
import com.danny.quizworld.course.subject.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/subjects")
public class ChapterApiController {

    private final CourseFacade courseFacade;

    @PostMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<ChapterResponse>> saveChapter(@PathVariable Long subjectId, @RequestBody ChapterCommand.save request) {
        courseFacade.saveChapter(subjectId, request);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 완료" , 201 ,null));
    }

    @GetMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<List<ChapterResponse>>> findAllChapterBySubjectId(@PathVariable Long subjectId , Authentication authentication) {
        Long memberId = Utils.getMemberId(authentication);
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllChapterBySubjectId(subjectId , memberId)));
    }

    @GetMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<ChapterResponse>> findChapterById(@PathVariable Long chapterId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findChapterById(chapterId)));
    }

    @PatchMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<SubjectResponse>> updateChapter(@PathVariable Long chapterId , @RequestBody ChapterCommand.update request){
        courseFacade.updateChapter(chapterId , request);
        return ResponseEntity.status(201).body(new ApiResponse<>("변경 완료" , 201 ,null));
    }

    @DeleteMapping("/chapters/{chapterId}")
    public ResponseEntity<ApiResponse<ChapterResponse>> deleteChapterById(@PathVariable Long chapterId) {
        courseFacade.deleteChapterById(chapterId);
        return ResponseEntity.status(201).body(new ApiResponse<>("삭제 완료" , 201 ,null));
    }

}
