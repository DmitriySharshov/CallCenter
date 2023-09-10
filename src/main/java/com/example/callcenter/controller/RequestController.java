package com.example.callcenter.controller;



import com.example.callcenter.entity.Request;
import com.example.callcenter.entity.RequestDto;
import com.example.callcenter.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;

    @PostMapping("/addRequest")
    public void addRequest(@RequestBody RequestDto requestDto){
        requestService.addRequest(requestDto);
    }

    @GetMapping( "/allRequestsClient/{idClient}")
    @ResponseBody
    public List<Request> getAllClientRequests(@PathVariable Long idClient){
        List<Request> response = requestService.getAllClientRequests(idClient);
        return response;
    }

    @GetMapping("/allReaquestEmployee/{idEmployee}")
    public List<Request> getAllEmployeeRequests(@PathVariable Long idEmployee){
        List<Request> response = requestService.getAllEmployeeRequests(idEmployee);
        return  response;
    }
}
