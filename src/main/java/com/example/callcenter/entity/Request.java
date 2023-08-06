package com.example.callcenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="requests")
public class Request {
    @Id
    @Column(name="idRequest")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRequest;
    @Column(name="idClient")
    private Long idClient;
    @Column(name="idEmployee")
    private Long idEmployee;
    @Column(name="msg")
    private String msg;

    @OneToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Client client;

    @OneToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Employee employee;
}
