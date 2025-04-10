package com.danny.quizworld.common.service;

import com.danny.quizworld.common.util.AES256Utils;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.member.Member;
import com.danny.quizworld.member.MemberRole;
import com.danny.quizworld.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberService memberService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();
        @SuppressWarnings("unchecked")
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse responseServlet = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        String authId = (String) response.get("id");
        String name = (String) response.get("name");
        String deviceToken = request.getHeader("X-Device-Token");


        Member member = getMember(authId, name);
        if(deviceToken != null){
            member.updateDeviceToken(deviceToken);
        }


        if (member.getLoginToken() == null || member.getLoginTokenExpiry() == null || member.getLoginTokenExpiry().isBefore(LocalDateTime.now())) {
            // 토큰이 없거나 만료되었으면 새로 발급
            String loginToken = Utils.generateToken();
            LocalDateTime loginTokenExpiry = LocalDateTime.now().plusDays(14);
            member.updateLoginToken(loginToken, loginTokenExpiry);
            memberService.save(member);

            Cookie cookie = new Cookie("remember-me-token", loginToken);
            cookie.setMaxAge(60 * 60 * 24 * 14);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            assert responseServlet != null;
            responseServlet.addCookie(cookie);
        }


        Map<String, Object> customAttributes = new HashMap<>(attributes);
        customAttributes.put("memberId", member.getMemberId());
        customAttributes.put("role", member.getRole().toString());
        customAttributes.put("authId", authId);

        request.getSession().removeAttribute("deviceToken");
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + member.getRole().toString())),
                customAttributes,
                "authId"
        );
    }

    private Member getMember(String authId, String name) {
        Member member = memberService.findByAuthId(AES256Utils.encrypt(authId));
        if (member == null) {
            String nickname;
            Long memberCount;

            do {
                nickname = Utils.generateUniqueNickname(name);
                memberCount = memberService.countByNickname(nickname);
            } while (memberCount > 0); // 닉네임 중복 시 반복

            Member newMember = memberService.toEntity(name, authId, nickname);
            member = memberService.save(newMember);
        }
        return member;
    }


}