package com.danny.quizworld.course.subject.category;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectRepository;
import com.danny.quizworld.course.subject.SubjectSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryReader {
    private final CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    public Category findById(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new MyException("카테고리를 찾을 수 없습니다."));
    }
}
