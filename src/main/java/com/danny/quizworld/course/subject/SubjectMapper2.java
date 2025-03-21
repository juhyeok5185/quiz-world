package com.danny.quizworld.course.subject;

import com.danny.quizworld.member.Member;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubjectMapper2 {

    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "downloadCount", constant = "0")
    @Mapping(target = "member", source = "member")
    @Mapping(target = "price", expression = "java(request.getPrice() == null ? 0L : request.getPrice())")
    Subject toEntity(Member member, SubjectCommand.save request);

    SubjectResponse toResponse(Subject subject);

    @Mapping(target = "member", source = "member")
    @Mapping(target = "name", source = "targetSubject.name")
    @Mapping(target = "description", source = "targetSubject.description")
    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "downloadCount", constant = "0")
    @Mapping(target = "publicYn", constant = "false")
    @Mapping(target = "price", constant = "0L")
    @Mapping(target = "downloadId", source = "targetSubject.subjectId")
    Subject copy(Subject targetSubject, Member member);
}
