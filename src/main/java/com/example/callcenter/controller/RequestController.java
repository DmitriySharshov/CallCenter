package com.example.callcenter.controller;



import com.example.callcenter.entity.Request;
import com.example.callcenter.entity.RequestDto;
import com.example.callcenter.service.RequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@Slf4j
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
        return requestService.getAllClientRequests(idClient);
    }

    @GetMapping("/allRequestEmployee/{idEmployee}")
    public List<Request> getAllEmployeeRequests(@PathVariable Long idEmployee){
        return requestService.getAllEmployeeRequests(idEmployee);
    }

    @GetMapping( "/requestForSpaceTime")
    public List<Request> getAllRequestForSpaceTime(@RequestParam(name = "fromTheDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate fromTheDate,
                                                   @RequestParam(name = "toTheDate") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate toTheDate){
        return requestService.getAllRequestForSpaceTime(fromTheDate,toTheDate);

    }

    @GetMapping("/msgOfRequest")
    public List<Request> getMessageOfRequest(@RequestParam(name = "fragmentOfMessage") String fragmentOfMessage){
        return requestService.getMessageOfRequest(fragmentOfMessage);
    }
}
