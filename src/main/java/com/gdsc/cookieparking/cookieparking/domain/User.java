package com.gdsc.cookieparking.cookieparking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    private String confirmPassword;

    private int parkingScore;

    private int readCount;

    private List<Cookie> cookies;

    private List<Directory> directories;

}
