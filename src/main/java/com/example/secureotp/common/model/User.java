package com.example.secureotp.common.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String otpSecret;

    private String firstName;

    private String lastName;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles", inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles = new ArrayList<Role>();


}
