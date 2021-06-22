package com.seymur.vabisstask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "is_enabled")
    private int isEnabled;

    @Column(name = "created", updatable = false)
    private LocalDateTime createDate;

    @PrePersist
    public void toCreate() {
        setCreateDate(LocalDateTime.now());
    }

}
