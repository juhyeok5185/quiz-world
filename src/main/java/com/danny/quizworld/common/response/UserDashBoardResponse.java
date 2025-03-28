package com.danny.quizworld.common.response;

import com.danny.quizworld.common.util.AES256Utils;
import com.danny.quizworld.member.MemberResponse;
import com.danny.quizworld.member.score.MemberScoreLogResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDashBoardResponse {
    private String name;
    private String nickname;
    private Integer score;
    private Integer likeCount;
    private Long mySubjectCount;
    private Long myStudyCount;
    private Long enrolledSubjectCount;
    private List<MemberScoreLogResponse> memberScoreLog;

    public void decryptName() {
        this.name = AES256Utils.decrypt(this.name);
        this.nickname = AES256Utils.decrypt(this.nickname);
    }
}
