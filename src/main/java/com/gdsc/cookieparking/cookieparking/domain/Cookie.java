package com.gdsc.cookieparking.cookieparking.domain;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@Entity
//@Data
@Builder
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

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="directory_id")
    private Directory directory;
}
