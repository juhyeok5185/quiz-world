package com.danny.quizworld.common.response;

import com.danny.quizworld.common.util.AES256Utils;
import com.danny.quizworld.member.MemberResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDashBoardResponse {
    private String name;
    private Integer score;
    private Integer likeCount;
    private Long mySubjectCount;
    private Long myStudyCount;
    private Long enrolledSubjectCount;

    public void decryptName() {
        this.name = AES256Utils.decrypt(this.name);
    }
}
