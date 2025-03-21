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
    private final StudyService studyService;

    //Subject 관련 API ---------------------------------------------------------------------------------------

    @Transactional
    public void saveSubject(Long memberId, SubjectRequest request) {
        Member member = memberService.findById(memberId);
        Subject subject = subjectService.toEntity(member, request);
        subjectService.save(subject);
    }

    @Transactional
    public void deleteSubjectById(Long subjectId) {
        List<Study> studyList = studyService.findAllBySubjectId(subjectId);
        studyService.deleteAll(studyList);
        List<Chapter> chapterList = chapterService.findAllBySubjectId(subjectId);
        chapterService.deleteAll(chapterList);
        Subject subject = subjectService.findById(subjectId);
        subjectService.delete(subject);
    }

    @Transactional(readOnly = true)
    public List<SubjectResponse> findAllByMemberId(Long memberId) {
        return subjectService.findAllByMemberId(memberId).stream().map(subject -> {
                    Long studyCount = studyService.countBySubjectId(subject.getSubjectId());
                    SubjectResponse subjectResponse = subjectService.toResponse(subject);
                    subjectResponse.setStudyCount(studyCount);
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
    public void saveChapter(Long subjectId, ChapterRequest request) {
        Subject subject = subjectService.findById(subjectId);
        Chapter chapter = chapterService.toEntity(subject, request);
        chapterService.save(chapter);
    }

    @Transactional
    public void deleteChapterById(Long chapterId) {
        List<Study> studyList = studyService.findAllByChapterId(chapterId);
        studyService.deleteAll(studyList);
        Chapter chapter = chapterService.findById(chapterId);
        chapterService.delete(chapter);
    }

    @Transactional(readOnly = true)
    public List<ChapterResponse> findAllChapterBySubjectId(Long subjectId) {
        return chapterService.findAllBySubjectId(subjectId).stream()
                .map(chapter -> {
                    Long studyCount = studyService.countByChapterId(chapter.getChapterId());
                    ChapterResponse chapterResponse = chapterService.toResponse(chapter);
                    chapterResponse.setStudyCount(studyCount);
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
        Study study = studyService.toEntity(chapter, request);
        studyService.save(study);
    }

    @Transactional
    public void updateStudy(Long studyId, StudyRequest request) {
        Study study = studyService.findById(studyId);
        study.update(request);
        studyService.save(study);
    }

    @Transactional
    public void deleteStudyById(Long studyId) {
        Study study = studyService.findById(studyId);
        studyService.delete(study);
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


}
