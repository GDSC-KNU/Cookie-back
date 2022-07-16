package com.gdsc.cookieparking.cookieparking.repository;

import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.service.DifferentPasswordException;
import com.gdsc.cookieparking.cookieparking.service.IdExistedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager em;

    @AfterEach
    private void after(){
        em.clear();
    }
    @Test
    public void saveUser throws Exception{
        //boolean existed = userRepository.existsByEmail(email);

        //if(existed) throw new RuntimeException();

        User user = User.builder().name("jiwon")
                .email("cutty824@naver.com")
                .password("12345678")
                .confirmPassword("12345678")
                .parkingScore(0)
                .readCount(0)
                .build();

        User saved = userRepository.save(user);

        User findMember = userRepository.findByEmail(saved.getEmail()).orElseThrow(() -> new RuntimeException("저장된 회원이 없습니다"));


    }


    @Test
    void findByEmail() {
    }

    @Test
    void existsByEmail() {
    }
}