package com.danny.quizworld.course.subject.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryStore {
    private final CategoryRepository categoryRepository;

}
