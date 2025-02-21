package com.danny.quizworld.question.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionFileService {

    private final QuestionFileReader questionFileReader;
    private final QuestionFileStore questionFileStore;


    private void save(QuestionFile questionFile){
        questionFileStore.save(questionFile);
    }

}
