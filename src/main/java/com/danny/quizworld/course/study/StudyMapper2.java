//package com.danny.quizworld.course.study;
//
//import com.danny.quizworld.course.chapter.Chapter;
//import com.danny.quizworld.course.chapter.ChapterMapper;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper(componentModel = "spring", uses = {ChapterMapper.class})
//public interface StudyMapper2 {
//
//    @Mapping(target = "subject", source = "chapter.subject")
//    Study toEntity(Chapter chapter, StudyCommand.save request);
//
//    StudyResponse toResponse(Study study);
//}
