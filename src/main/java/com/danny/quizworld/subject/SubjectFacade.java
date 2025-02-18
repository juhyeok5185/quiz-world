package com.danny.quizworld.subject;

import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberService;
import com.danny.quizworld.subject.chapter.Chapter;
import com.danny.quizworld.subject.chapter.ChapterResponse;
import com.danny.quizworld.subject.chapter.ChapterSaveRequest;
import com.danny.quizworld.subject.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectFacade {

    private final MemberService memberService;
    private final SubjectService subjectService;
    private final ChapterService chapterService;

    public SubjectResponse saveSubject(Long memberId, SubjectSaveRequest request) {
        Member member = memberService.findById(memberId);
        Subject subject = subjectService.toEntity(member , request);
        return subjectService.toResponse(subjectService.save(subject));
    }

    public List<SubjectResponse> findAllByMemberId(Long memberId) {
        List<Subject> subjectList = subjectService.findAllByMemberId(memberId);
        return subjectList.stream()
                .map(subjectService::toResponse)
                .toList();
    }

    public ChapterResponse saveChapter(Long subjectId, ChapterSaveRequest request) {
        Subject subject = subjectService.findById(subjectId);
        Chapter chapter = chapterService.toEntity(subject, request);
        return chapterService.toResponse(chapterService.save(chapter));
    }

    @Transactional(readOnly = true)
    public List<ChapterResponse> findAllChapterBySubjectId(Long subjectId) {
        List<Chapter> chapterList = chapterService.findAllBySubjectId(subjectId);
        return chapterList.stream()
                .map(chapterService::toResponse)
                .toList();
    }
}
