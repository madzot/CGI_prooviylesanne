package com.cgi.repository;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users", indexes = {@Index( name = "users_raw_name_uindex", columnList = "raw_name", unique = true)})
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "user_id")
    private Integer userID;

    private String firstName;
    private String lastName;
    private String email;
}
