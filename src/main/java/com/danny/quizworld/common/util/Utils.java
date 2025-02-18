package com.danny.quizworld.common.util;

import com.danny.quizworld.member.session.SessionDetails;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static Boolean isMobile(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return userAgent.toLowerCase().contains("android") ||
                userAgent.toLowerCase().contains("iphone") ||
                userAgent.toLowerCase().contains("ipad") ||
                userAgent.toLowerCase().contains("mobile");
    }

    public static String getRole(Authentication authentication) {
        if (authentication == null || authentication.getAuthorities() == null || authentication.getAuthorities().isEmpty()) {
            return null;
        }
        return authentication.getAuthorities().iterator().next().getAuthority();
    }

    public static Long getAuthId(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        return ((SessionDetails) principal).getAuthId();
    }
}
