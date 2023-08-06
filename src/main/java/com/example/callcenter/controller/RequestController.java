package com.example.callcenter.controller;

import com.example.callcenter.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;

    @PostMapping("/addRequest")
    public void addRequest(@PathVariable Long idClient,@PathVariable Long idEmployee,@PathVariable String msg){
        requestService.addRequest(idClient, idEmployee, msg);
    }


}
