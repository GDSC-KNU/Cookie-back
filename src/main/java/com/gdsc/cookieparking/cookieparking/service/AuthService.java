package com.gdsc.cookieparking.cookieparking.service;

import com.gdsc.cookieparking.cookieparking.domain.User;
import com.gdsc.cookieparking.cookieparking.provider.JwtTokenProvider;
import com.gdsc.cookieparking.cookieparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.reflect.annotation.ExceptionProxy;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String login(User request) throws Exception{
        User user = userRepository.findById(request.getId())
                .orElseThrow(()-> new UsernameNotFoundException("Not signed up User"));

        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new UsernameNotFoundException("");
        }

        return jwtTokenProvider.createToken(user.getId());
    }
}
