package com.danny.quizworld.course.subject;

import com.danny.quizworld.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubjectMapper {

    public Subject toEntity(Member member, SubjectCommand.save request) {
        return Subject.builder()
                .member(member)
                .name(request.getName())
                .description(request.getDescription())
                .likeCount(0)
                .downloadCount(0)
                .publicYn(request.getPublicYn())
                .price(request.getPrice() == null ? 0 : request.getPrice())
                .build();
    }

    public SubjectResponse toResponse(Subject subject) {
        return SubjectResponse.builder()
                .subjectId(subject.getSubjectId())
                .name(subject.getName())
                .description(subject.getDescription())
                .publicYn(subject.getPublicYn())
                .price(subject.getPrice())
                .likeCount(subject.getLikeCount())
                .downloadCount(subject.getDownloadCount())
                .build();
    }

    public Subject copy(Subject targetSubject, Member member) {
        return Subject.builder()
                .member(member)
                .name(targetSubject.getName())
                .description(targetSubject.getDescription())
                .likeCount(0)
                .downloadCount(0)
                .publicYn(false)
                .price(0L)
                .downloadId(targetSubject.getSubjectId())
                .build();
    }
}
