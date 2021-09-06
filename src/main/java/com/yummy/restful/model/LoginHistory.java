package com.yummy.restful.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "login_history")
@NoArgsConstructor
public class LoginHistory {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "login_history_id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "browser")
    private String browser;

    @Column(name = "user_id")
    private Long user;
}