package com.danny.quizworld.course;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.chapter.ChapterResponse;
import com.danny.quizworld.course.chapter.ChapterRequest;
import com.danny.quizworld.course.subject.SubjectRequest;
import com.danny.quizworld.course.subject.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses/subjects")
@RequiredArgsConstructor
public class CourseApiController {

    private final CourseFacade courseFacade;

    @PostMapping
    public ResponseEntity<ApiResponse<SubjectResponse>> saveSubject(Authentication authentication, @RequestBody SubjectRequest request) {
        Long memberId = Utils.getMemberId(authentication);
        return ResponseEntity.status(201).body(new ApiResponse<>(courseFacade.saveSubject(memberId, request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> findAllSubjectByMemberId(Authentication authentication) {
        Long memberId = Utils.getMemberId(authentication);
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllByMemberId(memberId)));
    }

    @PostMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<ChapterResponse>> saveChapter(@PathVariable Long subjectId, @RequestBody ChapterRequest request) {
        return ResponseEntity.status(201).body(new ApiResponse<>(courseFacade.saveChapter(subjectId, request)));
    }

    @GetMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<List<ChapterResponse>>> findAllChapterBySubjectId(@PathVariable Long subjectId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllChapterBySubjectId(subjectId)));
    }

}
