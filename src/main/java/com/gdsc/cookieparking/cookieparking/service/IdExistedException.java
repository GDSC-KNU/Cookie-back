package com.gdsc.cookieparking.cookieparking.service;

public class IdExistedException extends RuntimeException{

    IdExistedException() {
        super("이미 존재하는 Id입니다.");
    }
}
