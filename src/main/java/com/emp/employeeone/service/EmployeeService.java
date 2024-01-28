package com.emp.employeeone.service;

import com.emp.employeeone.dto.EmployeeDTO;
import com.emp.employeeone.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<EmployeeDTO>getAllEmployee();
    EmployeeDTO findEmployee(long id);
    String removeEmployee(long id);
    Employee updateEmployeeDetails(Employee employee,long id);
}
