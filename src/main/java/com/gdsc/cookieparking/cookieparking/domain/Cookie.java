package com.gdsc.cookieparking.cookieparking.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
public class Cookie {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    private String url;

    private String title;

    private String text;
}
