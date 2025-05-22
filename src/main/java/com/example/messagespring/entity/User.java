package com.example.messagespring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;


    @OneToMany(mappedBy = "user1")
    private List<DirectChats> sentChats;

    @OneToMany(mappedBy = "user2")
    private List<DirectChats> receivedChats;

    @OneToMany(mappedBy = "user")
    private List<Messages> messages;


    @OneToOne(mappedBy = "userId")
    private UserProfiles userProfiles;


}
