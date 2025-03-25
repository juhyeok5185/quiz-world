package com.danny.quizworld.member;

import com.danny.quizworld.common.response.UserDashBoardResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberDao {
    UserDashBoardResponse findUserDashBoardResponseByMemberId(@Param("memberId") Long memberId);

}
