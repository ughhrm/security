package com.backend.backendFinal;


import com.backend.backendFinal.jwt.JwtService;
import com.backend.backendFinal.model.security.Authority;
import com.backend.backendFinal.model.security.User;
import com.backend.backendFinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@RequiredArgsConstructor
@SpringBootApplication
@EnableJpaAuditing
public class BackendFinalApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public static void main(String[] args) {
        SpringApplication.run(BackendFinalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//            User user = new User();
//            user.setUsername("nazile");
//            user.setCity("sdu");
//            user.setEmail("nazile.@gmail.com");
//            user.setFirstName("Nazile");
//            user.setLastName("Nazile");
//            user.setPhone("05 0600 00 00");
//            user.setPassword(passwordEncoder.encode("nazile"));
//            user.setAccountNonExpired(true);
//            user.setAccountNonLocked(true);
//            user.setEnabled(true);
//            user.setCredentialsNonExpired(true);
//            Authority authority = new Authority();
//            authority.setAuthority("ADMIN");
//            authority.setUser(user);
//            user.setAuthorities(Set.of(authority));
//
//            user.setIssueToken(jwtService.issueToken(user));
//
//            userRepository.save(user);
    }



}
