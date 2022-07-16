package com.gdsc.cookieparking.cookieparking.service;

public class IdExistedException extends RuntimeException{

    IdExistedException(String id) {
        super(id + "는 이미 존재하는 Id입니다.");
    }
}
