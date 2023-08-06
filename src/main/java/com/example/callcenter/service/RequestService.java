package com.example.callcenter.service;

import com.example.callcenter.entity.Request;
import com.example.callcenter.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestService {
    private final RequestRepository requestRepository;
    public void addRequest(Long idClient, Long idEmployee, String msg) {
        Request request = new Request();
        request.setIdClient(idClient);
        request.setIdEmployee(idEmployee);
        request.setMsg(msg);
        requestRepository.save(request);
    }
}
