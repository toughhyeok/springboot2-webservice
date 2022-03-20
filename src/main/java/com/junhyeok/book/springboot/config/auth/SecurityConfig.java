package com.junhyeok.book.springboot.config.auth;

import com.junhyeok.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  // enable spring security configs
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                // disable to be able to use h2-console --> ??
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                // set/manage authorizations by urls
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                // allow access to /api/v1/ to user roles only
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                // anyRequest -> the rest of the urls
                .anyRequest().authenticated()   // only allow authenticated users to have access (logged in users)

                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                // set options for oauth2
                .oauth2Login()
                // set options for user info after successful login
                .userInfoEndpoint()
                // register UserService interface that defines actions handled after login is successful
                .userService(customOAuth2UserService);
    }
}