package com.junhyeok.book.springboot.config.auth.dto;

import com.junhyeok.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    // easier and better to serialize simple DTO class instead of the more complex entity class
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}