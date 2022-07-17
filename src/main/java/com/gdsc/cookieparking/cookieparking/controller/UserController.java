package com.gdsc.cookieparking.cookieparking.controller;

import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.service.CookieService;
import com.gdsc.cookieparking.cookieparking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{userId}")
    public User getUserData(@PathVariable String userId) {
        return userService.getUserData(userId);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> create(@RequestBody User resource) throws URISyntaxException {

        String id = resource.getId();
        String name = resource.getName();
        String email = resource.getEmail();
        String password = resource.getPassword();
        String confirmPassword = resource.getConfirmPassword();

        User user = userService.registerUser(id, name, email, password, confirmPassword);
        System.out.println("성공");
        String url = "/users/" +user.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

    //구현 완료 -> 계정 삭제하면 쿠키랑 디렉토리 모두 지워짐
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
