package com.danny.quizworld.member.score;

import com.danny.quizworld.common.util.AES256Utils;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MemberScoreLogMapper {

    @Mapping(target = "score", source = "member.score")
    @Mapping(target = "member", source = "member") // 👈 이거 추가해야 함!
    MemberScoreLog toEntity(Member member, Integer year, Integer month);


    MemberScoreLogResponse toResponse(MemberScoreLog memberScoreLog);

}
