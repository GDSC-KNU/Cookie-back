package com.gdsc.cookieparking.cookieparking.service;

import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 사용자 생성
    public User registerUser(String id, String name, String email, String password, String confirmPassword) {
        boolean existed = userRepository.existsByEmail(email);

        if(existed) throw new IdExistedException();

        if(password != confirmPassword) {
            throw new DifferentPasswordException();
        }

        User user = User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .confirmPassword(password)
                .parkingScore(0)
                .readCount(0)
                .build();

        return userRepository.save(user);
    }

    //TODO 사용자 삭제

    //TODO 사용자 정보 업데이트(이메일, 비밀번호)


}
