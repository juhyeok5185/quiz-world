package com.danny.quizworld.course;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.course.chapter.ChapterCommand;
import com.danny.quizworld.course.study.Study;
import com.danny.quizworld.course.study.StudyCommand;
import com.danny.quizworld.course.study.StudyResponse;
import com.danny.quizworld.course.study.StudyService;
import com.danny.quizworld.course.subject.*;
import com.danny.quizworld.course.subject.category.Category;
import com.danny.quizworld.course.subject.category.CategoryResponse;
import com.danny.quizworld.course.subject.category.CategoryService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CourseFacade {

    private final MemberService memberService;
    private final SubjectService subjectService;
    private final ChapterService chapterService;
    private final StudyService studyService;
    private final SubjectMemberService subjectMemberService;
    private final CategoryService categoryService;

    //Subject 관련 API ---------------------------------------------------------------------------------------
    @Transactional
    public void saveSubject(Long memberId, SubjectCommand.save request) {
        Member member = memberService.findById(memberId);
        subjectService.validateToSave(member, request);
        Category category = categoryService.findById(request.getCategoryId());
        Subject subject = subjectService.toEntity(member, category, request);
        subjectService.save(subject);
    }

    @Transactional
    public void updateSubject(Long subjectId, SubjectCommand.update request) {
        Subject subject = subjectService.findById(subjectId);
        subjectService.validateToUpdate(subject, request);
        Category category = categoryService.findById(request.getCategoryId());
        subject.update(request, category);
        subjectService.save(subject);
    }

    @Transactional
    public void deleteSubjectById(Long subjectId) {
        Long subjectMemberCount = subjectMemberService.countBySubjectId(subjectId);
        if(subjectMemberCount != 0){
            throw new MyException("유저가 사용중인 과목은 삭제할 수 없습니다.");
        }
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
        return subjectList.stream()
                .map(subject -> {
                    SubjectResponse response = subjectService.toResponse(subject);
                    response.setStudyCount(studyService.countBySubjectId(subject.getSubjectId()));
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SubjectResponse> findAllByMemberId(Long memberId) {
        List<Subject> mySubjects = subjectService.findAllByMemberId(memberId);
        List<Subject> purchasedSubjects = subjectMemberService.findByMemberId(memberId).stream()
                .map(SubjectMember::getSubject)
                .toList();

        return Stream.concat(purchasedSubjects.stream(), mySubjects.stream())
                .map(subject -> {
                    SubjectResponse response = subjectService.toResponse(subject);
                    response.setStudyCount(studyService.countBySubjectId(subject.getSubjectId()));
                    response.setCreateYn(Objects.equals(memberId, subject.getMember().getMemberId()));
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SubjectResponse findSubjectById(Long subjectId, Long memberId) {
        Subject subject = subjectService.findById(subjectId);
        SubjectResponse response = subjectService.toResponse(subject);
        response.setStudyCount(studyService.countBySubjectId(subjectId));
        response.setCreateYn(Objects.equals(memberId, subject.getMember().getMemberId()));
        return response;
    }

    @Transactional(readOnly = true)
    public SubjectResponse findSubjectByChapterId(Long chapterId, Long memberId) {
        Chapter chapter = chapterService.findById(chapterId);
        Subject subject = chapter.getSubject();
        SubjectResponse response = subjectService.toResponse(subject);
        response.setStudyCount(studyService.countBySubjectId(subject.getSubjectId()));
        response.setCreateYn(Objects.equals(memberId, subject.getMember().getMemberId()));
        return response;
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
    public List<ChapterResponse> findAllChapterBySubjectId(Long subjectId, Long memberId) {
        return chapterService.findAllBySubjectId(subjectId).stream()
                .filter(chapter -> {
                    boolean createYnCondition = Objects.equals(memberId, chapter.getSubject().getMember().getMemberId());
                    boolean isPublic = chapter.getPublicYn();
                    return createYnCondition || isPublic;
                })
                .map(chapter -> {
                    boolean createYnCondition = Objects.equals(memberId, chapter.getSubject().getMember().getMemberId());
                    Long studyCount = studyService.countByChapterId(chapter.getChapterId());
                    ChapterResponse chapterResponse = chapterService.toResponse(chapter);
                    chapterResponse.setStudyCount(studyCount);
                    chapterResponse.getSubject().setCreateYn(createYnCondition);
                    return chapterResponse;
                })
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public ChapterResponse findChapterById(Long chapterId, Long memberId) {
        Chapter chapter = chapterService.findById(chapterId);
        ChapterResponse chapterResponse = chapterService.toResponse(chapter);
        chapterResponse.setStudyCount(studyService.countByChapterId(chapterId));
        chapterResponse.getSubject().setCreateYn(Objects.equals(memberId, chapter.getSubject().getMember().getMemberId()));
        return chapterResponse;
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
    public List<StudyResponse> findAllStudyByChapterId(Long chapterId, Long memberId) {
        List<Study> studyList = studyService.findAllByChapterId(chapterId);
        return studyList.stream()
                .map(chapter -> {
                    StudyResponse studyResponse = studyService.toResponse(chapter);
                    studyResponse.getChapter().getSubject().setCreateYn(Objects.equals(memberId, chapter.getChapter().getSubject().getMember().getMemberId()));
                    return studyResponse;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StudyResponse findStudyById(Long studyId) {
        return studyService.toResponse(studyService.findById(studyId));
    }


    //SubjectMember 관련 API ---------------------------------------------------------------------------------------
    @Transactional
    public void saveSubjectMember(String subjectId, Long memberId) {
        Member member = memberService.findById(memberId);
        Subject subject = subjectService.findById(Long.parseLong(subjectId));
        SubjectMember checkSubjectMember = subjectMemberService.findBySubjectIdAndMemberId(subject.getSubjectId(), member.getMemberId());
        subjectMemberService.validateToSave(member, subject, checkSubjectMember);
        SubjectMember subjectMember = subjectMemberService.toEntity(subject, member);
        subjectMemberService.save(subjectMember);
        subject.addDownloadCnt();
        subjectService.save(subject);
    }

    @Transactional
    public void deleteSubjectMemberBySubjectIdAndMemberId(Long subjectId, Long memberId) {
        SubjectMember subjectMember = subjectMemberService.findBySubjectIdAndMemberId(subjectId, memberId);
        subjectMemberService.delete(subjectMember);
    }

    //Category 관련 API --------------------------------------------------------------------------------------------
    @Transactional(readOnly = true)
    public List<CategoryResponse> findAllCategory() {
        List<Category> categoryList = categoryService.findAllCategory();
        return categoryList.stream().map(categoryService::toResponse).collect(Collectors.toList());
    }


}
