package com.user.managment.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // todo add validation
    @Column(name = "first_name")
    private String firstName;
    // todo add validation
    @Column(name = "last_name")
    private String lastName;

    //todo validate email with regex
    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address")
    private String address;
    // todo add validation
    @Column(name = "phone_number")
    private String phoneNumber;
}
