package com.danny.quizworld.common.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class Utils {

    public static Boolean isMobile(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return userAgent.toLowerCase().contains("android") ||
                userAgent.toLowerCase().contains("iphone") ||
                userAgent.toLowerCase().contains("ipad") ||
                userAgent.toLowerCase().contains("mobile");
    }

    public static String getRole(Authentication authentication) {
        if (authentication == null) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof DefaultOAuth2User) {
            DefaultOAuth2User oauth2User = (DefaultOAuth2User) principal;
            return oauth2User.getAuthorities()
                    .stream()
                    .findFirst()
                    .map(authority -> authority.getAuthority())
                    .orElse(null);
        }

        return null;
    }

    public static Long getMemberId(Authentication authentication) {
        if (authentication == null) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof DefaultOAuth2User) {
            DefaultOAuth2User oauth2User = (DefaultOAuth2User) principal;
            return Long.valueOf(oauth2User.getAttribute("memberId").toString());
        }

        return null;
    }


    public static String generateUniqueNickname(String baseName) {
        String nickname;
        int randNum = (int) (Math.random() * 9000) + 1000; // 1000~9999
        nickname = baseName + "_" + randNum;
        return nickname;
    }

    public static Integer getLastMonth() {
        return LocalDate.now().minusMonths(1).getMonthValue();
    }

    public static Integer getLastMonthYear() {
        return LocalDate.now().minusMonths(1).getYear();
    }

}
