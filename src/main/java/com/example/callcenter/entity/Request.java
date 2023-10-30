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

    @Column(name="msg")
    private String msg;

    @JoinColumn(name="idClient")
    @OneToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Client client;

    @JoinColumn(name="idEmployee")
    @OneToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Employee employee;
}
