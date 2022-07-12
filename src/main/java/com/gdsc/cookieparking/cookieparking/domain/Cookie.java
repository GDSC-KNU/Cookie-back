package com.gdsc.cookieparking.cookieparking.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cookie")
@Setter
@ToString
public class Cookie {

    @Id
    @GeneratedValue
    private Long id;

    private String url;

    private String title;

    private String text;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="directory_id")
    private Directory directory = new Directory();
}
