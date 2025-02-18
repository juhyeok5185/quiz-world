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

    @Transactional
    public String login(@Valid SessionRequest request) {
        String encryptedLoginId = AES256Utils.encrypt(request.getLoginId());
        Member member = memberService.findByLoginId(encryptedLoginId);

        if (member == null) {
            throw new MyException("없는 계정입니다.");
        }

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new MyException("비밀번호를 잘못 입력했습니다.");
        }

        SessionDetails sessionDetails = new SessionDetails(member.getMemberId(), member.getLoginId(), member.getPassword(), member.getName(), member.getRole());
        Authentication authentication = new UsernamePasswordAuthenticationToken(sessionDetails, null, sessionDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return member.getRole().equals(MemberRole.ADMIN) ? "/admin/main" : "/user/main";

    }
}
