package com.example.messagespring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class UserProfiles {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;


    private String profilePicture;
    private String status;
    private Date lastSeen;
    private String createdBy;


}
