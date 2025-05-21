package com.backend.backendFinal.config;
import com.backend.backendFinal.filter.JwtAuthFilterConfigurerAdapter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class
WebSecurityConfig {
    private final JwtAuthFilterConfigurerAdapter configurerAdapter;

//    private final JwtAuthFilter jwtAuthFilter;
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public EnableSpringDataWebSupport.SpringDataWebSettingsRegistar springDataWebSettingsRegistar() {
        return new EnableSpringDataWebSupport.SpringDataWebSettingsRegistar();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.apply(configurerAdapter);
        http
               .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->

                        auth
                                .requestMatchers("/api/users/**").permitAll()
                                .requestMatchers("/categories","/categories/*").hasAuthority("ADMIN")
                                .requestMatchers(
                                        "/v3/api-docs/**",
                                        "/swagger-ui/**",
                                        "/swagger-ui.html"
                                ).permitAll()

                                .anyRequest()
                                .authenticated()
                ).exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint((request, response, authException) ->
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
                        )
                        .accessDeniedHandler((request, response, accessDeniedException) ->
                                response.setStatus(HttpServletResponse.SC_FORBIDDEN)
                        )
                ).httpBasic(Customizer.withDefaults());

        return http.build();

    }
}