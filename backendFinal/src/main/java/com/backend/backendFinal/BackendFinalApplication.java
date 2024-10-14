package com.backend.backendFinal;


import com.backend.backendFinal.jwt.JwtService;
import com.backend.backendFinal.model.security.User;
import com.backend.backendFinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@SpringBootApplication
public class BackendFinalApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public static void main(String[] args) {
        SpringApplication.run(BackendFinalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.findById(1).ifPresent(user -> {
//            user.setUsername("user");

//            user.setIssueToken(jwtService.issueToken(user));

//            userRepository.save(user);
        });
    }
//        User user = new User();
//        user.setUsername("admin1");
//        user.setPassword(passwordEncoder.encode("admin1"));
//        user.setAccountNonExpired(true);
//        user.setAccountNonLocked(true);
//        user.setEnabled(true);
//        user.setCredentialsNonExpired(true);
//        Authority authority = new Authority();
//        authority.setAuthority("USER");
//        authority.setUser(user);

//        user.setAuthorities(Set.of(authority));
//        userRepository.save(user);


}
