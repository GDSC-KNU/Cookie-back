package com.gdsc.cookieparking.cookieparking.service;

import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if(existed) throw new IdExistedException(id);

        if(!isSamePassword(password, confirmPassword)) {
            throw new DifferentPasswordException();
        }

        User user = User.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .confirmPassword(confirmPassword)
                .parkingScore(0)
                //.readCount(0)
                .build();
        user.setCookies();
        user.setDirectories();

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    //TODO 사용자 삭제
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    //TODO 사용자 정보 업데이트(이메일, 비밀번호)


    public User getUserData(String id) {
        User user = userRepository.findById(id).orElse(null);
        System.out.println(user);
        return user;

    }

}
