package com.gdsc.cookieparking.cookieparking.controller;

import com.gdsc.cookieparking.cookieparking.domain.Cookie;
import com.gdsc.cookieparking.cookieparking.domain.CookieDTO;
import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CookieController {

    @Autowired
    CookieService cookieService;



    @GetMapping("/cookies/{userId}")
    public List<Cookie> list(@PathVariable("userId") String userId) {
        return cookieService.getCookieList(userId);
    }

    @PostMapping("cookies")
    public Cookie create(@RequestBody CookieDTO resource) throws IOException {
        CookieDTO cookie = new CookieDTO();
        cookie.setUserId(resource.getUserId());
        cookie.setDirectoryId(resource.getDirectoryId());
        cookie.setUrl(resource.getUrl());

        //System.out.println("\n\n\n\"" + userId + " " + );
        return cookieService.addCookie(cookie.getUserId(), cookie.getDirectoryId(), cookie.getUrl());
    }


    //TODO 쿠키 업데이트 매핑 추가할 것
    @PutMapping("cookies/{cookieId}")
    public Cookie update(@RequestBody CookieDTO resource) {
        Cookie cookie = new Cookie();
        return null;
    }

    // TODO 쿠키 삭제 매핑 추가할 것
    @DeleteMapping("/cookies/{cookieId}")
    public void delete(@PathVariable("cookieId") Long cookieId) {
        cookieService.deleteCookie(cookieId);
    }
}

