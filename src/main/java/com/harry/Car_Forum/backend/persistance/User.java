package com.harry.Car_Forum.backend.persistance;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name="email")
    String email;

    @Column(name="login")
    String login;

    @Column(name="password")
    String password;
}
