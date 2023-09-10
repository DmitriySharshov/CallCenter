package com.example.callcenter.service;

import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Employee;
import com.example.callcenter.entity.Request;
import com.example.callcenter.entity.TransferRequest;
import com.example.callcenter.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import java.util.List;


@SpringBootApplication
@Service
@RequiredArgsConstructor
@Slf4j

public class RequestService {
    private final RequestRepository requestRepository;

    private final ClientService clientService;
    private final EmployeeService employeeService;



    public void addRequest(TransferRequest transferRequest) {
        Client client = clientService.getDataClient(transferRequest.getFrom());
        Employee employee = employeeService.getDataEmployee(transferRequest.getTo());
        String msg = transferRequest.getMsg();

        if(client == null || employee == null) throw new IllegalArgumentException();

        Request request = new Request();
        request.setClient(client);
        request.setEmployee(employee);
        request.setMsg(msg);

        requestRepository.save(request);
    }

    public List<Request> getAllClientRequests(Long idClient) {
        List <Request> requestList;
        Client client = clientService.getDataClient(idClient);
            requestList = requestRepository.getRequestsByClient(client);
        return requestList;
    }

    public List<Request> getAllEmployeeRequests(Long idEmployee) {
        List<Request> requestList;
        Employee employee = employeeService.getDataEmployee(idEmployee);
        requestList = requestRepository.getRequestsByEmployee(employee);
        return requestList;
    }
}
