package com.example.callcenter.service;
import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Request;
import com.example.callcenter.repository.ClientRepository;
import com.example.callcenter.repository.RequestRepository;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;
    public  Client getDataClient(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    public boolean postDataClient(Client client) {
        clientRepository.save(client);
        return true;
    }

    public void deleteClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }


}


