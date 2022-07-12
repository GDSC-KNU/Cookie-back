package com.gdsc.cookieparking.cookieparking.service;

import com.gdsc.cookieparking.cookieparking.domain.Cookie;
import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.repository.CookieRepository;
import com.gdsc.cookieparking.cookieparking.repository.DirectoryRepository;
import com.gdsc.cookieparking.cookieparking.repository.UserRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CookieService {

    @Autowired
    private CookieRepository cookieRepository;

    @Autowired
    private DirectoryRepository directoryRepository;
    @Autowired
    UserRepository userRepository;

    public Cookie addCookie(String userId, String url) throws IOException {
        User owner = userRepository.findById(userId).orElse(null);

        Cookie cookie = Cookie.builder()
                .url(url)
                .build();
        cookie.setUser(owner);

        cookie.setTitle(makeTitle(url));
        cookie.setText(makeText(url));
        cookie.setDirectory(null);
        owner.addCookie(cookie);
        return cookieRepository.save(cookie);
    }

    public Cookie updateCookie(Long id, String title, String text, Long directoryId) {
        //TODO : DB에서 쿠키 id로 찾아서 쿠키 가져오고 title이랑 text 변경
        Cookie cookie = cookieRepository.findById(id).orElse(null);

        cookie.setTitle(title);
        cookie.setText(text);

        if(directoryId == null)
            cookie.setDirectory(null);
        else
            cookie.setDirectory(directoryRepository.findById(directoryId).orElse(null));

        return cookieRepository.save(cookie);
    }

    //테스트 필요
    public void deleteCookie(Long id) {
        cookieRepository.deleteById(id);

    }


    public List<Cookie> getCookieList(String userId) {
        return cookieRepository.findAllByUserId(userId);

    }

    public String makeTitle(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        return document.title();
    }

    public String makeText(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        String text = document.select("meta[property=og:description]").get(0).attr("content");
        return text;
    }


}


