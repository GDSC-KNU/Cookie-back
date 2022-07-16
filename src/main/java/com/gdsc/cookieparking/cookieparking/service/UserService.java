package com.gdsc.cookieparking.cookieparking.service;

import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;
import java.util.Optional;

import static com.gdsc.cookieparking.cookieparking.domain.User.isSamePassword;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 사용자 생성
    public User registerUser(String id, String name, String email, String password, String confirmPassword) {
        boolean existed = userRepository.existsById(id);

        if(existed) throw new KeyAlreadyExistsException();

        if(!isSamePassword(password, confirmPassword)) {
            throw new IllegalArgumentException();
        }

        User user = User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .parkingScore(0)
                .build();
        //System.out.println(user.getEmail());
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    //TODO 사용자 삭제
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User getUserData(String id){
        User user = userRepository.findById(id).orElse(null);

        User userData = User.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .directories(user.getDirectories())
                        .cookies(user.getCookies())
                                .build();

        System.out.println(user.getCookies());

        return userData;
    }

}
