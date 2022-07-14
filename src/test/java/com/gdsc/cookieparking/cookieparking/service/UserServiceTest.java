package com.gdsc.cookieparking.cookieparking.service;

import com.gdsc.cookieparking.cookieparking.domain.Cookie;
import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.repository.CookieRepository;
import com.gdsc.cookieparking.cookieparking.repository.DirectoryRepository;
import com.gdsc.cookieparking.cookieparking.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.gdsc.cookieparking.cookieparking.domain.User.isSamePassword;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private CookieService cookieService;



    @BeforeEach
    void beforeEach() {
        givenUser("A1", "조유리","abc1@naver.com", "1234", "1234");
        givenUser("A2", "장원영","abc2@naver.com", "1234", "1234");
        givenUser("A3", "최예나","abc3@naver.com", "1234", "1234");

    }
    @Test
    void userList() {
        givenUsers();


        List<User> result = userService.getUsers();
        result.forEach(System.out::println);
    }


    @Test
    void userCookieList() throws IOException {

        givenCookies();
        List<User> result = userService.getUsers();

        for(User user: result) {
            System.out.println(user);
            List<Cookie> cookieList = cookieService.getCookieList(user.getId());
            for(Cookie cookie : cookieList) {
                System.out.println(cookie);
            }
        }
        //result.forEach(System.out::println);
    }


    private void givenUsers() {

        givenUser("A2", "장원영","abc2@naver.com", "1234", "1234");
        givenUser("A3", "최예나","abc3@naver.com", "1234", "1234");

    }



    private void givenUser(String id, String name, String email, String password, String confirmPassword) {

        userService.registerUser(id,name,email,password,confirmPassword);
    }

    private void givenCookies() throws IOException {

        givenCookie("A1", null,"https://www.naver.com");
        givenCookie("A2", null,"https://www.naver.com");
        givenCookie("A1", null,"https://www.naver.com");
        givenCookie("A3", null,"https://www.naver.com");
    }
    private void givenCookie(String userId,Long directoryId, String url) throws IOException {
        cookieService.addCookie(userId,directoryId, url);

    }

}