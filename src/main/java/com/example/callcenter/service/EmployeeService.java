package com.example.callcenter.service;

import com.example.callcenter.entity.Employee;
import com.example.callcenter.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
@Slf4j
@RequiredArgsConstructor

public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    public Employee getDataEmployee(Long idEmployee) {
        return employeeRepository.findById(idEmployee).orElse(null);
    }

    public Employee postDataEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long idEmployee) { employeeRepository.deleteById(idEmployee);
    }
}
