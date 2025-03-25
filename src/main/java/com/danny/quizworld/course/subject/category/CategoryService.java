package com.danny.quizworld.course.subject.category;

import com.danny.quizworld.course.subject.*;
import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryReader categoryReader;
    private final CategoryStore categoryStore;
    private final CategoryMapper categoryMapper;

    @Transactional(readOnly = true)
    public List<Category> findAllCategory() {
        return categoryReader.findAllCategory();
    }

    public CategoryResponse toResponse(Category category) {
        return categoryMapper.toResponse(category);
    }

    public Category findById(Integer categoryId) {
        return categoryReader.findById(categoryId);
    }
}
