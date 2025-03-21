package com.danny.quizworld.course;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.course.chapter.ChapterCommand;
import com.danny.quizworld.course.study.Study;
import com.danny.quizworld.course.study.StudyCommand;
import com.danny.quizworld.course.study.StudyResponse;
import com.danny.quizworld.course.study.StudyService;
import com.danny.quizworld.course.subject.*;
import com.danny.quizworld.course.subject.member.SubjectMember;
import com.danny.quizworld.course.subject.member.SubjectMemberService;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberService;
import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.chapter.ChapterResponse;
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
    private final SubjectMemberService subjectMemberService;

    //Subject 관련 API ---------------------------------------------------------------------------------------
    @Transactional
    public void saveSubject(Long memberId, SubjectCommand.save request) {
        Member member = memberService.findById(memberId);
        subjectService.validateToSave(member ,request);
        Subject subject = subjectService.toEntity(member, request);
        subjectService.save(subject);
    }

    @Transactional
    public void updateSubject(Long subjectId, SubjectCommand.update request) {
        Subject subject = subjectService.findById(subjectId);
        subjectService.validateToUpdate(subject , request);
        subject.update(request);
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
    public List<SubjectResponse> findAllSubjectBySearch(SubjectSearch search) {
        List<Subject> subjectList = subjectService.findAllSubjectBySearch(search);
        return subjectList.stream().map(subjectService::toResponse).collect(Collectors.toList());
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

    @Transactional(readOnly = true)
    public void downloadSubject(Long subjectId, Long memberId) {
        Subject targetSubject = subjectService.findById(subjectId);

        if (targetSubject.getPrice() != 0){
            SubjectMember subjectMember = subjectMemberService.findBySubjectIdAndMemberId(targetSubject.getSubjectId() , memberId);
            if(subjectMember == null){
                throw new MyException("결제 후에 다운로드 가능합니다.");
            }
        }

        Member member = memberService.findById(memberId);
        Subject subject = subjectService.copy(targetSubject , member);
        subjectService.save(subject);
    }

    //Chapter 관련 API ---------------------------------------------------------------------------------------
    @Transactional
    public void saveChapter(Long subjectId, ChapterCommand.save request) {
        Subject subject = subjectService.findById(subjectId);
        Chapter chapter = chapterService.toEntity(subject, request);
        chapterService.save(chapter);
    }

    @Transactional
    public void updateChapter(Long chapterId, ChapterCommand.update request) {
        Chapter chapter = chapterService.findById(chapterId);
        chapter.update(request);
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
    public void saveStudy(Long chapterId, StudyCommand.save request) {
        Chapter chapter = chapterService.findById(chapterId);
        Study study = studyService.toEntity(chapter, request);
        studyService.save(study);
    }

    @Transactional
    public void updateStudy(Long studyId, StudyCommand.update request) {
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

    public void saveSubjectMember(String subjectId, Long memberId) {
        Member member = memberService.findById(memberId);
        Subject subject = subjectService.findById(Long.parseLong(subjectId));
        SubjectMember subjectMember = subjectMemberService.toEntity(subject , member);
        subjectMemberService.save(subjectMember);
    }
}
