package com.danny.quizworld.subject;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import com.danny.quizworld.subject.chapter.ChapterSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectApiController {

    private final SubjectFacade subjectFacade;

    @PostMapping
    public ResponseEntity<ApiResponse<SubjectResponse>> saveSubject(Authentication authentication, @RequestBody SubjectSaveRequest request) {
//        Long memberId = Utils.getAuthId(authentication);
        Long memberId = null;
        return ResponseEntity.status(201).body(new ApiResponse<>(subjectFacade.saveSubject(memberId, request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> findAllSubjectByMemberId(Authentication authentication) {
//        Long memberId = Utils.getAuthId(authentication);
        Long memberId = null;
        return ResponseEntity.ok(new ApiResponse<>(subjectFacade.findAllByMemberId(memberId)));

    }

    @PostMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<ChapterResponse>> saveChapter(@PathVariable Long subjectId, @RequestBody ChapterSaveRequest request) {
        return ResponseEntity.status(201).body(new ApiResponse<>(subjectFacade.saveChapter(subjectId, request)));
    }

    @GetMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<List<ChapterResponse>>> findAllChapterBySubjectId(@PathVariable Long subjectId) {
        return ResponseEntity.ok(new ApiResponse<>(subjectFacade.findAllChapterBySubjectId(subjectId)));
    }

}
