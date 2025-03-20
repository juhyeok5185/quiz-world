package com.danny.quizworld.quiz.file;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuestionFileService {

    private final QuestionFileReader questionFileReader;
    private final QuestionFileStore questionFileStore;

    @Transactional
    public void save(QuestionFile questionFile){
        questionFileStore.save(questionFile);
    }

    public String getSaveFilename(final String filename) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = FilenameUtils.getExtension(filename);
        return uuid + "." + extension;
    }


}
