package com.example.callcenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="employeers")

public class Employee {
    private static final String SEQ_NAME = "employee_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long idEmployee;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<Request> request;

}
