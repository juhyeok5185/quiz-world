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

import javax.servlet.http.HttpServletRequest;
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

        String authId = (String) response.get("id");
        String name = (String) response.get("name");
        //구글일때
//        String email = (String) attributes.get("email");
//        String name = (String) attributes.get("name");


        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String deviceToken = (String) request.getSession().getAttribute("deviceToken");

        Member member = memberService.findByAuthId(AES256Utils.encrypt(authId));
        if(member == null){
            String nickname;
            Long memberCount;

            do {
                nickname = Utils.generateUniqueNickname(name);
                memberCount = memberService.countByNickname(nickname);
            } while (memberCount > 0); // 닉네임 중복 시 반복

            Member newMember = memberService.toEntity(name, authId, nickname);
            member = memberService.save(newMember);
        }

        if(deviceToken != null){
            member.updateDeviceToken(deviceToken);
            memberService.save(member);
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
}