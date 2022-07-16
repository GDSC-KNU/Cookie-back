package com.gdsc.cookieparking.cookieparking.controller;

import com.gdsc.cookieparking.cookieparking.domain.Cookie;
import com.gdsc.cookieparking.cookieparking.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CookieController {

    @Autowired
    CookieService cookieService;

    @GetMapping("users/{userId}/cookies")
    public List<Cookie> list(@PathVariable("userId") String userId) {
        return cookieService.getCookieList(userId);
    }

    @PostMapping("{userId}/cookies")
    public Cookie create(@PathVariable("userId") String userId, String url) throws IOException {
        return cookieService.addCookie(userId, url);
    }


    //TODO 쿠키 업데이트 매핑 추가할 것
    // TODO 쿠키 삭제 매핑 추가할 것
    @DeleteMapping("/cookies/{cookieId}")
    public void delete(@PathVariable("cookieId") Long cookieId) {
        cookieService.deleteCookie(cookieId);
    }
}

