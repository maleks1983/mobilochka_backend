package com.mobilochka.backend.model.users;


import com.mobilochka.backend.model.AbstractIdEntyty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
public class Users extends AbstractIdEntyty{

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    private Date registered = new Date();


    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;


    public Users(String user_name, String email, String password, Set<Role> roles) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
