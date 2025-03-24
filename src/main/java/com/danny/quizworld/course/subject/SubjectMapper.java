package com.danny.quizworld.course.subject;

import com.danny.quizworld.member.Member;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "downloadCount", constant = "0")
    @Mapping(target = "member", source = "member")
    @Mapping(target = "price", expression = "java(request.getPrice() == null ? 0L : request.getPrice())")
    Subject toEntity(Member member, SubjectCommand.save request);


    SubjectResponse toResponse(Subject subject);

}
