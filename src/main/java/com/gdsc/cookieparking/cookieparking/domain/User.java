package com.gdsc.cookieparking.cookieparking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.*;

import org.springframework.security.crypto.password.PasswordEncoder;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Table(name = "USER")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String email;

    private String password;

    @Transient
    private String confirmPassword;

    private int parkingScore;

    @ToString.Exclude
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cookie> cookies;

<<<<<<< HEAD
   // @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Directory> directories = new HashSet<>();
=======
    @ToString.Exclude
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Directory> directories;

    public User(String id, String name, String email, String password, String confirmPassword ) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        parkingScore = 0;
    }

    public void setCookies() {
        this.cookies = new ArrayList<Cookie>();
    }
    public void setDirectories() {
        this.directories = new ArrayList<Directory>();
    }
>>>>>>> main

    public void addCookie(Cookie cookie) {
        cookie.setUser(this);
        cookies.add(cookie);
        this.parkingScore++;
    }

    public void addDirectory(Directory directory) {

        directory.setUser(this);
        directories.add(directory);
    }

    public static boolean isSamePassword(String password, String confirmPassword) {
        if(password.equals(confirmPassword)) return true;
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
