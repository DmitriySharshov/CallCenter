package com.example.callcenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="requests")
public class Request {
    private static final String SEQ_NAME = "request_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long idRequest;

    @Column(name="msg")
    private String msg;


    @CreationTimestamp
    @Column(name="date_created")
    private LocalDate dateCreated;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Client client;

    @ManyToOne (cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Employee employee;


}
