package com.junhyeok.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  // determines where the annotation can be used
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    // @interface defines an annotation class -> @LoginUser
}