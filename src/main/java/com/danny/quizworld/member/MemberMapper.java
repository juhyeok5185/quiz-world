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

    public Member toEntity(MemberSaveRequest request) {
        return Member.builder()
                .loginId(AES256Utils.encrypt(request.getLoginId()))
                .password(passwordEncoder.encode(request.getPassword()))
                .name(AES256Utils.encrypt(request.getName()))
                .email(AES256Utils.encrypt(request.getEmail()))
                .phone(AES256Utils.encrypt(request.getPhone()))
                .role(request.getRole())
                .deviceToken(null)
                .build();
    }

    public MemberResponse toResponse(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .loginId(AES256Utils.decrypt(member.getLoginId()))
                .email(AES256Utils.decrypt(member.getEmail()))
                .name(AES256Utils.decrypt(member.getName()))
                .phone(AES256Utils.decrypt(member.getPhone()))
                .build();
    }
}
