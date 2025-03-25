package com.danny.quizworld.course.subject.category;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.CourseFacade;
import com.danny.quizworld.course.chapter.ChapterResponse;
import com.danny.quizworld.course.subject.SubjectCommand;
import com.danny.quizworld.course.subject.SubjectResponse;
import com.danny.quizworld.course.subject.SubjectSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/subjects/categories")
public class CategoryApiController {

    private final CourseFacade courseFacade;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> findAllCategory(){
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllCategory()));
    }

}
