package com.example.callcenter.service;
import com.example.callcenter.entity.Client;
import com.example.callcenter.repository.ClientRepository;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;
    public  Client getDataClient(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    public Client postDataClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }


}


