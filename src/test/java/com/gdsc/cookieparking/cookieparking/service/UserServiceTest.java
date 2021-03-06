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
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private DirectoryService directoryService;


    @BeforeEach
    void beforeEach() throws IOException {
        givenUser("A1", "조유리","abc1@naver.com", "1234", "1234");
        givenUser("A2", "장원영","abc2@naver.com", "1234", "1234");
        givenUser("A3", "최예나","abc3@naver.com", "1234", "1234");
        //givenDirectories();
        //givenCookies();

    }
    @Test
    void userList() {
        //givenUsers();


        List<User> result = userService.getUsers();
        result.forEach(System.out::println);
    }

    @Test
    void print() {
        System.out.println("테스트 시작");
    }


    @Test
    @Transactional
    void userCookieList() throws IOException {

        givenCookies();
        List<User> result = userService.getUsers();
        System.out.println("_______________________________________");
        System.out.println(result);
        /*for(User user: result) {
            System.out.println(user);
            List<Cookie> cookieList = cookieService.getCookieList(user.getId());
            for(Cookie cookie : cookieList) {
                System.out.println(cookie);
            }
        }*/
        //result.forEach(System.out::println);
    }


    private void givenUsers() {

        givenUser("A4", "장원영","abc2@naver.com", "1234", "1234");
        givenUser("A5", "최예나","abc3@naver.com", "1234", "1234");

    }



    private void givenUser(String id, String name, String email, String password, String confirmPassword) {

        userService.registerUser(id,name,email,password,confirmPassword);
    }

    private void givenCookies() throws IOException {

        givenCookie("A1", null,"https://www.naver.com");
        givenCookie("A1", null,"https://jogeum.net/8");
        givenCookie("A1", null,"https://www.daum.net");
        givenCookie("A1", null,"https://www.nexon.com");
    }





    private void givenCookie(String userId,Long directoryId, String url) throws IOException {
        cookieService.addCookie(userId,directoryId, url);

    }

<<<<<<< HEAD
}
=======
    private void givenDirectories() {
        givenDirectory("A1", "test1");
        //givenDirectory("A1", "test2");
    }
    private void givenDirectory(String userId, String name) {
        directoryService.addDirectory(userId, name);
    }

}
>>>>>>> main
