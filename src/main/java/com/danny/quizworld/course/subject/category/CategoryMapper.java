package com.danny.quizworld.course.subject.category;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectCommand;
import com.danny.quizworld.course.subject.SubjectResponse;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(String name);

    CategoryResponse toResponse(Category category);
}
