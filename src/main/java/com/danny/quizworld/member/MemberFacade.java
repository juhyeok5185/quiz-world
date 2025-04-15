package com.danny.quizworld.member;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.common.response.UserDashBoardResponse;
import com.danny.quizworld.course.chapter.Chapter;
import com.danny.quizworld.course.chapter.ChapterService;
import com.danny.quizworld.course.study.Study;
import com.danny.quizworld.course.study.StudyService;
import com.danny.quizworld.course.subject.Subject;
import com.danny.quizworld.course.subject.SubjectRepository;
import com.danny.quizworld.course.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;
    private final SubjectService subjectService;
    private final ChapterService chapterService;
    private final StudyService studyService;

    @Transactional(readOnly = true)
    public MemberResponse findByIdToResponse(Long memberId) {
        return memberService.toResponse(memberService.findById(memberId));
    }

    @Transactional
    public void addScore(Long memberId) {
        Member member = memberService.findById(memberId);
        member.addScore();
        memberService.save(member);
    }

    @Transactional(readOnly = true)
    public UserDashBoardResponse findUserDashBoardResponseByMemberId(Long memberId) {
        UserDashBoardResponse response = memberService.findUserDashBoardResponseByMemberId(memberId);
        response.decryptName();
        return response;
    }

    @Transactional
    public void updateNickname(MemberCommand.updateNickname request, Long memberId) {
        Long checkMember = memberService.countByNickname(request.getNickname());
        if(checkMember > 0){
            throw new MyException("같은 닉네임이 존재합니다.");
        }
        Member member = memberService.findById(memberId);
        member.updateNickname(request.getNickname());
        memberService.save(member);
    }

    public void deleteMember(Long memberId) {
        Member member = memberService.findById(memberId);
        List<Subject> subjectList = subjectService.findAllByMemberId(memberId);
        subjectList.forEach(subject -> {
            List<Chapter> chapterList = chapterService.findAllBySubjectId(subject.getSubjectId());
            chapterList.forEach(chapter -> {
                List<Study> studyList = studyService.findAllByChapterId(chapter.getChapterId());
                studyService.deleteAll(studyList);
            });
            chapterService.deleteAll(chapterList);
        });
        subjectService.deleteAll(subjectList);
        memberService.delete(member);
    }
}
