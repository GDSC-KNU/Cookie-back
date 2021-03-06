package com.gdsc.cookieparking.cookieparking.service;

import com.gdsc.cookieparking.cookieparking.domain.Cookie;
import com.gdsc.cookieparking.cookieparking.domain.Directory;
import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.repository.CookieRepository;
import com.gdsc.cookieparking.cookieparking.repository.DirectoryRepository;
import com.gdsc.cookieparking.cookieparking.repository.UserRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class CookieService {

    @Autowired
    private CookieRepository cookieRepository;

    @Autowired
    private DirectoryRepository directoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Cookie addCookie(String userId, Long directoryId, String url) throws IOException {

        User owner = userRepository.findById(userId).orElse(null);

        //Directory directory = directoryRepository.findById(directoryId).orElse(null);

        Cookie cookie = new Cookie();

        cookie.setUrl(url);
        cookie.setTitle(makeTitle(url));
        cookie.setText(makeText(url));
        cookie.setUser(owner);
        cookie.setDirectory(null);

        owner.addCookie(cookie);

        userRepository.save(owner);
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
        //TODO 안되는 사이트들 있어서 조건 추가 필요!! 좀더 확실히 해야함
        Document document = Jsoup.connect(url).get();
        String text = document.select("meta[property=og:description]").get(0).attr("content");
        return text;
    }


}


