package com.example.callcenter.repository;

import com.example.callcenter.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findEmployeeById(Long idEmployee);
}
