package com.example.callcenter.controller;

import com.example.callcenter.entity.Client;
import com.example.callcenter.service.ClientService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{idClient}")
    public Client getDataClient(@PathVariable Long idClient){
        return clientService.getDataClient(idClient);
    }

    @PostMapping ("/addClient")
    public void postDataClient(@RequestBody Client client)  {
        clientService.postDataClient(client);
    }

    @PostMapping
    public void deleteClient(@PathVariable Long idClient){ clientService.deleteClient(idClient);}

}


