//package com.danny.quizworld.common.config;
//
//import com.danny.quizworld.member.Member;
//import com.danny.quizworld.member.MemberService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.Map;
//
//@Component
//@RequiredArgsConstructor
//public class RememberMeAuthFilter extends OncePerRequestFilter {
//
//    private final MemberService memberService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        if (SecurityContextHolder.getContext().getAuthentication() == null) {
//            Cookie[] cookies = request.getCookies();
//            if (cookies != null) {
//                for (Cookie cookie : cookies) {
//                    if ("remember-me-token".equals(cookie.getName())) {
//                        String token = cookie.getValue();
//                        Member member = memberService.findByLoginToken(token);
//
//                        if (member != null && member.getLoginTokenExpiry() != null
//                                && member.getLoginTokenExpiry().isAfter(LocalDateTime.now())) {
//
//                            Map<String, Object> attributes = Map.of(
//                                    "memberId", member.getMemberId(),
//                                    "authId", member.getAuthId(),
//                                    "role", member.getRole().toString()
//                            );
//
//                            DefaultOAuth2User oAuth2User = new DefaultOAuth2User(
//                                    Collections.singleton(new SimpleGrantedAuthority("ROLE_" + member.getRole())),
//                                    attributes,
//                                    "authId"
//                            );
//
//                            OAuth2AuthenticationToken auth = new OAuth2AuthenticationToken(
//                                    oAuth2User,
//                                    oAuth2User.getAuthorities(),
//                                    "naver"
//                            );
//
//                            SecurityContextHolder.getContext().setAuthentication(auth);
//
//                            // 🔥 자동 로그인 성공 시 리다이렉트
//                            if (request.getRequestURI().equals("/login")) {
//                                String redirectUrl = "ROLE_ADMIN".equals("ROLE_" + member.getRole())
//                                        ? "/admin/main"
//                                        : "/user/main";
//                                response.sendRedirect(redirectUrl);
//                                return; // 필터 체인 타지 않고 종료
//                            }
//
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//}