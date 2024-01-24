package com.example.callcenter.service;

import com.example.callcenter.entity.Client;


import com.example.callcenter.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@AllArgsConstructor
@NoArgsConstructor
@RunWith(SpringRunner.class)
@SpringBootTest
class ClientServiceTest {

    @Autowired
    private ClientService clientService;



    @Test
    void postDataClient() {
        Client client = new Client("τττ","τττ","τττ","τττ","ττττ");
        boolean isClientCreated = clientService.postDataClient(client);
        Assert.assertTrue(isClientCreated);
    }
}