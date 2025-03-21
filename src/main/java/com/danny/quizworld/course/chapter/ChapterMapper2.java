//package com.danny.quizworld.course.chapter;
//
//import com.danny.quizworld.course.subject.Subject;
//import com.danny.quizworld.course.subject.SubjectMapper;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring", uses = {SubjectMapper.class})
//public interface ChapterMapper2 {
//
//    @Mapping(target = "subject", source = "subject")
//    Chapter toEntity(Subject subject, ChapterCommand.save request);
//
//    ChapterResponse toResponse(Chapter chapter);
//}
