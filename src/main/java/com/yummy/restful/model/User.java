package com.yummy.restful.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.yummy.restful.model.enums.UserStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usr")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private UserStatus status;

    @JsonIgnore
    @OneToMany(mappedBy ="user",  fetch = FetchType.EAGER)
    private List<Order> orders;
}