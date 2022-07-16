package com.gdsc.cookieparking.cookieparking.repository;

import com.gdsc.cookieparking.cookieparking.domain.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookieRepository extends JpaRepository<Cookie, Long> {

    List<Cookie> findAllByUserId(String userId);

}
