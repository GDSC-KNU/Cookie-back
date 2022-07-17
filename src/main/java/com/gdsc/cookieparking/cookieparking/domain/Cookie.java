package com.gdsc.cookieparking.cookieparking.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cookie")
@Setter
@ToString
public class Cookie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String title;

    private String text;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="directory_id")
    private Directory directory;

    public Cookie(String url, String title, String text, User user, Directory directory) {
        this.url = url;
        this.title = title;
        this.text = text;
        this.user =user;
        this.directory =directory;
    }
}
