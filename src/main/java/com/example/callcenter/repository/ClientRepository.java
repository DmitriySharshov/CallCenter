package com.example.callcenter.repository;

import com.example.callcenter.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientById(Long idClient);

}
