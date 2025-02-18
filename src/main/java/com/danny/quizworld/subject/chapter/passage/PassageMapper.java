package com.danny.quizworld.subject.chapter.passage;

import com.danny.quizworld.subject.Subject;
import com.danny.quizworld.subject.SubjectService;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import com.danny.quizworld.subject.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PassageMapper {

    private final ModelMapper modelMapper;
    private final ChapterService chapterService;

    public Passage toEntity(Chapter chapter, String text){
        return Passage.builder()
                .subject(chapter.getSubject())
                .chapter(chapter)
                .text(text)
                .build();
    }

    public PassageResponse toResponse(Passage passage) {
        return PassageResponse.builder()
                .passageId(passage.getPassageId())
                .text(passage.getText())
                .chapter(chapterService.toResponse(passage.getChapter()))
                .build();
    }
}
