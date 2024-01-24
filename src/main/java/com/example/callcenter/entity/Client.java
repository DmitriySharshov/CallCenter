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
@Table(name="clients")

public class Client {
    private static final String SEQ_NAME = "client_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private  Long idClient;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="phone")
    private String phone;
    //@Column(name="email")
    private String email;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List <Request> request;

    public Client(String name, String surname, String lastname, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }
}
