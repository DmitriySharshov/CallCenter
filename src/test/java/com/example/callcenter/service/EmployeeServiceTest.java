package com.example.callcenter.service;

import com.example.callcenter.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void postDataEmployee(){
        Employee employee = new Employee();
        employee.setName("Test_Employee");
        Employee createdEmployee = employeeService.postDataEmployee(employee);
        Assert.assertTrue(createdEmployee!=null);

        Long id = createdEmployee.getIdEmployee();
        Employee dbEmployee = employeeService.getDataEmployee(id);
        Assert.assertTrue(dbEmployee!=null);

        employeeService.deleteEmployee(dbEmployee.getIdEmployee());
        Employee afterDelete = employeeService.getDataEmployee(dbEmployee.getIdEmployee());
        Assert.assertTrue(afterDelete==null);
    }

}