package com.gdsc.cookieparking.cookieparking.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Table(name = "USER_TABLE")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String name;

    private String email;

    private String password;

    private String confirmPassword;

    private int parkingScore;

    //@ToString.Exclude
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Cookie> cookies = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Directory> directories = new HashSet<>();

    public void addCookie(Cookie cookie) {
        if(cookies == null)
            cookies = new HashSet<>();
        cookie.setUser(this);
        cookies.add(cookie);
        this.parkingScore++;
    }

    public void addDirectory(Directory directory) {
        if(directories == null)
            directories = new HashSet<>();

        directory.setUser(this);
        directories.add(directory);
    }

    public static boolean isSamePassword(String password, String confirmPassword) {
        if(password.equals(confirmPassword))
            return true;
        return false;
    }

    public void updatePassword(PasswordEncoder passwordEncoder, String password){
        this.password = passwordEncoder.encode(password);
    }

    public void updateName(String name){
        this.name = name;
    }

    //패스워드 암호화
    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(password);
    }
}
