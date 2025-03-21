package com.danny.quizworld.course;

import com.danny.quizworld.course.study.Study;
import com.danny.quizworld.course.study.StudyRequest;
import com.danny.quizworld.course.study.StudyResponse;
import com.danny.quizworld.course.study.StudyService;
import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectRequest;
import com.danny.quizworld.course.subject.SubjectResponse;
import com.danny.quizworld.course.subject.SubjectService;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberService;
import com.danny.quizworld.exam.question.QuestionService;
import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.chapter.ChapterResponse;
import com.danny.quizworld.course.chapter.ChapterRequest;
import com.danny.quizworld.course.chapter.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseFacade {

    private final MemberService memberService;
    private final SubjectService subjectService;
    private final ChapterService chapterService;
    private final QuestionService questionService;
    private final StudyService studyService;

    //Subject 관련 API ---------------------------------------------------------------------------------------

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

    @Transactional(readOnly = true)
    public SubjectResponse findSubjectById(Long subjectId) {
        return subjectService.toResponse(subjectService.findById(subjectId));
    }


    //Chapter 관련 API ---------------------------------------------------------------------------------------

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

    @Transactional(readOnly = true)
    public ChapterResponse findChapterById(Long chapterId) {
        return chapterService.toResponse(chapterService.findById(chapterId));
    }

    //Study 관련 API ---------------------------------------------------------------------------------------

    @Transactional
    public void saveStudy(Long chapterId, StudyRequest request) {
        Chapter chapter = chapterService.findById(chapterId);
        Subject subject = chapter.getSubject();
        Study study = studyService.toEntity(chapter, request);
        studyService.save(study);
    }

    @Transactional(readOnly = true)
    public List<StudyResponse> findAllStudyByChapterId(Long chapterId) {
        List<Study> studyList = studyService.findAllByChapterId(chapterId);
        return studyList.stream()
                .map(studyService::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StudyResponse findStudyById(Long studyId) {
        return studyService.toResponse(studyService.findById(studyId));
    }

    @Transactional
    public void updateStudy(Long studyId, StudyRequest request) {
        Study study = studyService.findById(studyId);
        study.update(request);
        studyService.save(study);
    }

}
