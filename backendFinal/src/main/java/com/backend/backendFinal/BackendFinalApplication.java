package com.backend.backendFinal;


import com.backend.backendFinal.jwt.JwtService;
import com.backend.backendFinal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@SpringBootApplication
@EnableJpaAuditing

public class BackendFinalApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(BackendFinalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }



}
