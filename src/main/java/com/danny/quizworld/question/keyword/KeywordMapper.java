package com.danny.quizworld.question.keyword;

import com.danny.quizworld.question.Question;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeywordMapper {

    private final ModelMapper modelMapper;

    public Keyword toEntity(Question question, String name){
        return Keyword.builder()
                .question(question)
                .name(name)
                .build();
    }
}
