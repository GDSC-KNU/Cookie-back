package com.gdsc.cookieparking.cookieparking.controller;

import com.gdsc.cookieparking.cookieparking.domain.User;
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


    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User resource) throws URISyntaxException {

        String id = resource.getId();
        String name = resource.getName();
        String email = resource.getEmail();
        String password = resource.getPassword();
        String confirmPassword = resource.getConfirmPassword();

        User user = userService.registerUser(id, name, email, password, confirmPassword);
        String url = "/users/" + user.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
