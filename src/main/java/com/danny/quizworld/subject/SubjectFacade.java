package com.danny.quizworld.subject;

import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberService;
import com.danny.quizworld.question.Question;
import com.danny.quizworld.question.QuestionResponse;
import com.danny.quizworld.question.QuestionService;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import com.danny.quizworld.subject.chapter.ChapterRequest;
import com.danny.quizworld.subject.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectFacade {

    private final MemberService memberService;
    private final SubjectService subjectService;
    private final ChapterService chapterService;
    private final QuestionService questionService;

    @Transactional
    public SubjectResponse saveSubject(Long memberId, SubjectRequest request) {
        Member member = memberService.findById(memberId);
        Subject subject = subjectService.toEntity(member, request);
        return subjectService.toResponse(subjectService.save(subject));
    }

    @Transactional(readOnly = true)
    public List<SubjectResponse> findAllByMemberId(Long memberId) {
        return subjectService.findAllByMemberId(memberId).stream().map(subject -> {
                    Long quizCount = questionService.countBySubjectId(subject.getSubjectId());
                    SubjectResponse subjectResponse = subjectService.toResponse(subject);
                    subjectResponse.setQuizCount(quizCount);
                    return subjectResponse;
                })
                .collect(Collectors.toList());

    }

    @Transactional
    public ChapterResponse saveChapter(Long subjectId, ChapterRequest request) {
        Subject subject = subjectService.findById(subjectId);
        Chapter chapter = chapterService.toEntity(subject, request);
        return chapterService.toResponse(chapterService.save(chapter));
    }

    @Transactional(readOnly = true)
    public List<ChapterResponse> findAllChapterBySubjectId(Long subjectId) {
        return chapterService.findAllBySubjectId(subjectId).stream()
                .map(chapter -> {
                    Long quizCount = questionService.countByChapterId(chapter.getChapterId());
                    ChapterResponse chapterResponse = chapterService.toResponse(chapter);
                    chapterResponse.setQuizCount(quizCount);
                    return chapterResponse;
                })
                .collect(Collectors.toList());
    }

}
