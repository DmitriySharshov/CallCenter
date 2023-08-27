package com.example.callcenter.service;

import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Employee;
import com.example.callcenter.entity.Request;
import com.example.callcenter.entity.TransferRequest;
import com.example.callcenter.repository.ClientRepository;
import com.example.callcenter.repository.EmployeeRepository;
import com.example.callcenter.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


@SpringBootApplication
@Service
@RequiredArgsConstructor
@Slf4j

public class RequestService {
    private final RequestRepository requestRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;



    public void addRequest(TransferRequest transferRequest) {
        Client client = clientRepository.findClientById(transferRequest.getFrom());
        Employee employee = employeeRepository.findEmployeeById(transferRequest.getTo());
        String msg = transferRequest.getMsg();

        if(client == null || employee == null) throw new IllegalArgumentException();

        Request request = new Request();
        request.setClient(client);
        request.setEmployee(employee);
        request.setMsg(msg);

        requestRepository.save(request);
    }
}
