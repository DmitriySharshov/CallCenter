package com.example.callcenter.controller;

import com.example.callcenter.entity.Client;
import com.example.callcenter.service.ClientService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
//@Api(description = "Контроллер для описания работы Swagger")
public class ClientController {

    public final ClientService clientService;

    @GetMapping("/getClient/{idClient}")
    //@ApiOperation("Получение клиента")
    public Client getDataClient(@PathVariable Long idClient){
        return clientService.getDataClient(idClient);
    }

    @PostMapping ("/addClient")
    //@ApiOperation("Добавление клиента")
    public void postDataClient(@RequestBody Client client)  {
        clientService.postDataClient(client);
    }

    @PostMapping("/deleteClient/{idClient}")
    //@ApiOperation("Удаление клиента")
    public void deleteClient(@PathVariable Long idClient){ clientService.deleteClient(idClient);}


}


