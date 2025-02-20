package com.danny.quizworld.member;

import com.danny.quizworld.common.util.AES256Utils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
@RequiredArgsConstructor
public class MemberMapper {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public Member toEntity(String name , String email) {
        return Member.builder()
                .name(AES256Utils.encrypt(name))
                .email(AES256Utils.encrypt(email))
                .role(MemberRole.USER)
                .deviceToken(null)
                .build();
    }

    public MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .email(AES256Utils.decrypt(member.getEmail()))
                .name(AES256Utils.decrypt(member.getName()))
                .build();
    }
}
