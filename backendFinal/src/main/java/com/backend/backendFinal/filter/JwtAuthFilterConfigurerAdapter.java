package com.backend.backendFinal.filter;

import com.backend.backendFinal.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class JwtAuthFilterConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private static final Logger log = LoggerFactory.getLogger(JwtAuthFilterConfigurerAdapter.class);
    private final List<AuthService> authService;

    @Override
    public void configure(HttpSecurity http) {
        log.trace("Added auth request filter");
        http.addFilterBefore(new JwtAuthFilter(authService), UsernamePasswordAuthenticationFilter.class);
    }
}
