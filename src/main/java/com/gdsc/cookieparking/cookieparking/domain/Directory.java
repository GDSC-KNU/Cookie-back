package com.gdsc.cookieparking.cookieparking.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id")
    private User user;

    private String name;

    private String emoji;

    @ToString.Exclude
    @JsonIgnore
   // @JsonManagedReference
    @OneToMany(mappedBy = "directory", fetch = FetchType.LAZY)
    private List<Cookie> cookie = new ArrayList<>();
}
