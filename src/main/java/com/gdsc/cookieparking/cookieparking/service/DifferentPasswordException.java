package com.gdsc.cookieparking.cookieparking.service;

public class DifferentPasswordException extends RuntimeException{
    DifferentPasswordException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
