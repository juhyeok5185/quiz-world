package com.danny.quizworld.course.subject;

import com.danny.quizworld.course.subject.category.Category;
import com.danny.quizworld.course.subject.category.CategoryMapper;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberMapper;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {MemberMapper.class , CategoryMapper.class})
public interface SubjectMapper {

    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "downloadCount", constant = "0")
    @Mapping(target = "member", source = "member")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "price", expression = "java(request.getPrice() == null ? 0L : request.getPrice())")
    @Mapping(target = "downloadYn", ignore = true)
    @Mapping(target = "downloadId", ignore = true)
    Subject toEntity(Member member, Category category, SubjectCommand.save request);


    @Mapping(target = "member", source = "member")
    @Mapping(target = "studyCount", ignore = true)
    @Mapping(target = "createYn", ignore = true)
    SubjectResponse toResponse(Subject subject);
}
