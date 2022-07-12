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
        String url = "https://www.naver.com/";
        Document document = Jsoup.connect(url).get();
        System.out.println(document.title());
        //String info = elements
    }

    @Test
    void makeText() throws IOException{
        String url = "https://www.naver.com/";
        Document document = Jsoup.connect(url).get();
        String text = document.select("meta[property=og:description]").get(0).attr("content");
        System.out.println(text);


    }
}