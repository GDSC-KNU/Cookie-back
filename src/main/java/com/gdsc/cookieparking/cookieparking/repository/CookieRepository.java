package com.gdsc.cookieparking.cookieparking.repository;

import com.gdsc.cookieparking.cookieparking.domain.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CookieRepository extends JpaRepository<Cookie, Long> {

    List<Cookie> findAllByUserId(String userId);

}
