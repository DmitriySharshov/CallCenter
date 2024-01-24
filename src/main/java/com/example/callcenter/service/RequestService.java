package com.example.callcenter.service;

import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Employee;
import com.example.callcenter.entity.Request;
import com.example.callcenter.entity.RequestDto;
import com.example.callcenter.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;



@Service
@RequiredArgsConstructor
@Slf4j



public class RequestService {

    private final RequestRepository requestRepository;
    private final ClientService clientService;
    private final EmployeeService employeeService;





    public void addRequest(RequestDto requestDto) {
        Client client = clientService.getDataClient(requestDto.getIdClient());
        Employee employee = employeeService.getDataEmployee(requestDto.getIdEmployee());
        String msg = requestDto.getMsg();

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

    public List<Request> getAllRequestForSpaceTime(LocalDate fromTheDate, LocalDate toTheDate) {
        return requestRepository.getRequestsByDateCreatedBetween(fromTheDate,toTheDate);
    }

    public List <Request> getMessageOfRequest(String fragmentOfMessage) {
        List <Request> requestList = requestRepository.getMsgFragmentMessage(fragmentOfMessage);
        return requestList;
    }

    public void writeToFile (List<Request> requestList){
        //List<Request> requestList = requestRepository.findAll();
        try{
            FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\requests.txt");
            for (Request request :requestList) {
                writer.write(request.getIdRequest()+" "+request.getMsg()+" "+request.getClient()+
                        " "+request.getEmployee()+" "+request.getDateCreated()+" "+System.getProperty("line.separator"));
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Ошибка создания файла!");
        }
    }
}
