package com.example.callcenter.service;

import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Employee;
import com.example.callcenter.entity.Request;
import com.example.callcenter.entity.RequestDto;
import com.example.callcenter.repository.RequestRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class RequestServiceTest {

    @Autowired
    private RequestService requestService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;


    @Autowired
    private RequestRepository requestRepository;

    @Test
    void postRequest(){

        Client client = new Client();
        client.setName("Test");
        Client createdClient =  clientService.postDataClient(client);
        Employee employee = new Employee();
        employee.setName("Test1");
        Employee createdEmployee = employeeService.postDataEmployee(employee);


        RequestDto dto = new RequestDto();
        dto.setIdClient(createdClient.getIdClient());
        dto.setIdEmployee(createdEmployee.getIdEmployee());
        dto.setMsg("Test_Msg");

        Request createdRequest = requestService.addRequest(dto);
        Assert.assertNotNull("Test_add_request",createdRequest);
    }

    @Test
    void getEmployeeAllRequest(){
        Employee employee = new Employee();
        employee.setName("Test_Employee");
        Employee createdEmployee = employeeService.postDataEmployee(employee);

        Employee dbEmployee = employeeService.getDataEmployee(createdEmployee.getIdEmployee());
        List<Request> requestsList;
        requestsList = requestRepository.getRequestsByEmployee(dbEmployee);
        Assert.assertNotNull(requestsList);
    }

    @Test
    void getClientAllRequest(){
        Client client = new Client();
        client.setName("Test_client");
        Client createdClient = clientService.postDataClient(client);

        Client dbClient = clientService.getDataClient(createdClient.getIdClient());
        List<Request> requestList;
        requestList = requestRepository.getRequestsByClient(dbClient);
        Assert.assertNotNull(requestList);
    }
}