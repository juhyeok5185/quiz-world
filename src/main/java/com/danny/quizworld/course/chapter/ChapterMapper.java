package com.danny.quizworld.course.chapter;

import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {SubjectMapper.class})
public interface ChapterMapper {

    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "publicYn", source = "request.publicYn")
    Chapter toEntity(Subject subject, ChapterCommand.save request);

    ChapterResponse toResponse(Chapter chapter);
}
