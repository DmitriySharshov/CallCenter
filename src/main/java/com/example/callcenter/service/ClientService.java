package com.example.callcenter.service;
import com.example.callcenter.entity.Client;
import com.example.callcenter.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;
    public  Client getDataClient(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    public void postDataClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

}


