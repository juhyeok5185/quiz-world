package com.danny.quizworld.quiz.passage;

import com.danny.quizworld.course.chapter.Chapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PassageService {

    private final PassageStore passageStore;
    private final PassageMapper passageMapper;
    private final PassageReader passageReader;

    @Transactional
    public Passage save(Passage passage){
        return passageStore.save(passage);
    }

    public Passage toEntity(Chapter chapter , String text){
        return passageMapper.toEntity(chapter, text);
    }

    public PassageResponse toResponse(Passage passage){
        return passageMapper.toResponse(passage);
    }

}
