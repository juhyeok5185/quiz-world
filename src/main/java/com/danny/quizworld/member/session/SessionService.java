package com.danny.quizworld.member.session;

import com.danny.quizworld.common.config.MyException;
import com.danny.quizworld.common.util.AES256Utils;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberReader;
import com.danny.quizworld.member.MemberRole;
import com.danny.quizworld.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

}
