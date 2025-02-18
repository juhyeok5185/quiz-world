package com.danny.quizworld.subject;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.subject.chapter.ChapterResponse;
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
    public ResponseEntity<ApiResponse<SubjectResponse>> saveSubject(Authentication authentication, @RequestBody String name) {
        Long memberId = Utils.getAuthId(authentication);
        return ResponseEntity.status(201).body(new ApiResponse<>(subjectFacade.saveSubject(memberId, name)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubjectResponse>>> findAllSubjectByMemberId(Authentication authentication) {
        Long memberId = Utils.getAuthId(authentication);
        return ResponseEntity.ok(new ApiResponse<>(subjectFacade.findAllByMemberId(memberId)));
    }

    @PostMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<ChapterResponse>> saveChapter(@PathVariable Long subjectId, @RequestBody String name) {
        return ResponseEntity.status(201).body(new ApiResponse<>(subjectFacade.saveChapter(subjectId, name)));
    }

    @GetMapping("/{subjectId}/chapters")
    public ResponseEntity<ApiResponse<List<ChapterResponse>>> findAllChapterBySubjectId(@PathVariable Long subjectId) {
        return ResponseEntity.ok(new ApiResponse<>(subjectFacade.findAllChapterBySubjectId(subjectId)));
    }

}
