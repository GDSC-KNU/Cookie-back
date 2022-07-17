package com.gdsc.cookieparking.cookieparking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtToken {

    private String account;

    private String password;
}
