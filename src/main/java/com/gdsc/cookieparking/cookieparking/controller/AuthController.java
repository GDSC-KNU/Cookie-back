package com.gdsc.cookieparking.cookieparking.controller;


import com.gdsc.cookieparking.cookieparking.domain.JwtToken;
import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.service.AuthService;
import com.gdsc.cookieparking.cookieparking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody User request) throws Exception{

        return authService.login(request);

    }
}
