package com.gdsc.cookieparking.cookieparking.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CookieServiceTest {

    @Test
    void makeTitle() throws IOException {
        String url = "https://chaibin0.tistory.com/entry/%EC%9B%B9%EC%97%90%EC%84%9C-%EA%B7%B8%EB%A6%B4-%EC%88%98-%EC%9E%88%EB%8A%94-UML%EC%82%AC%EC%9D%B4%ED%8A%B8-drawio";
        Document document = Jsoup.connect(url).get();
        System.out.println(document.title());
        //String info = elements
    }

    @Test
    void makeText() throws IOException{
        String url = "https://chaibin0.tistory.com/entry/%EC%9B%B9%EC%97%90%EC%84%9C-%EA%B7%B8%EB%A6%B4-%EC%88%98-%EC%9E%88%EB%8A%94-UML%EC%82%AC%EC%9D%B4%ED%8A%B8-drawio";
        Document document = Jsoup.connect(url).get();
        String text = document.select("meta[property=og:description]").get(0).attr("content");
        System.out.println(text);


    }
}