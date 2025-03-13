package com.danny.quizworld.common.controller;

import com.danny.quizworld.common.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PageController {



    @GetMapping("/")
    public String index(Authentication authentication) {
        if(authentication == null){
            return "redirect:login";
        }

        if(Utils.getRole(authentication).equals("ROLE_ADMIN")){
            return "redirect:admin/main";
        }

        return "redirect:user/main";
    }

    @GetMapping("/{firstUrl}")
    public String firstUrl(@PathVariable String firstUrl , Authentication authentication) {

        if(firstUrl.equals("login")){
            if(authentication != null){
                if(Utils.getRole(authentication).equals("ROLE_ADMIN")){
                    return "redirect:admin/main";
                }
                return "redirect:user/main";
            }
        }
        return firstUrl;
    }

    @GetMapping("/design/{firstUrl}")
    public String designFirstUrl(@PathVariable String firstUrl) {
        return "design/" + firstUrl;
    }

    @GetMapping("/user/{firstUrl}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userFirstUrl(@PathVariable String firstUrl) {
        return "user/" + firstUrl;
    }

    @GetMapping("/admin/{firstUrl}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminFirstUrl(@PathVariable String firstUrl) {
        return "admin/" + firstUrl;
    }

}
