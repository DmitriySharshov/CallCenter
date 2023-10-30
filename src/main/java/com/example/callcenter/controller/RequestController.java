package com.example.callcenter.controller;

import com.example.callcenter.entity.TransferRequest;
import com.example.callcenter.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;

    @PostMapping("/addRequest")
    public void addRequest(@RequestBody TransferRequest transferRequest){
        requestService.addRequest(transferRequest);
    }


}
