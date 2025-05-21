package com.backend.backendFinal.model.security;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String password;
    private String username;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private String issueToken;
    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String city;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;



    @ToString.Exclude
    @EqualsExclude
    @OneToMany( mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Authority> authorities;

}
