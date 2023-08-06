package com.example.callcenter.controller;

import com.example.callcenter.entity.Employee;
import com.example.callcenter.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{idEmployee}")
    public Employee getDataEmployee(@PathVariable Long idEmployee){return  employeeService.getDataEmployee(idEmployee);}

    @PostMapping("/addEmployee")
    public void postDataEmployee(@RequestBody Employee employee){employeeService.postDataEmployee(employee);}

    @PostMapping
    public void deleteEmployee(@PathVariable Long idEmployee){
        employeeService.deleteEmployee(idEmployee);
    }
}


