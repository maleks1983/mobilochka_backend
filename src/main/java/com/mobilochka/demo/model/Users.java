package com.mobilochka.demo.model;


import javax.persistence.*;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "userid")
    private AtomicLong user_id;
    @Column(name = "username")
    private String user_name;

    private Role role;
}
