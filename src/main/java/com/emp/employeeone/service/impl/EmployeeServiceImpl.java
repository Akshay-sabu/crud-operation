package com.emp.employeeone.service.impl;

import com.emp.employeeone.dto.EmployeeDTO;
import com.emp.employeeone.exception.EmployeeNotFound;
import com.emp.employeeone.model.Employee;
import com.emp.employeeone.repository.EmployeeRepository;
import com.emp.employeeone.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS=new ArrayList<>();
        for(Employee emp:employees){
            EmployeeDTO employeeDTO=new EmployeeDTO();
            employeeDTO.setId(emp.getId());
            employeeDTO.setName(emp.getName());
            employeeDTO.setEmail(emp.getEmail());
            employeeDTOS.add(employeeDTO);
        }
        return employeeDTOS;
    }
    @Override
    public EmployeeDTO findEmployee(long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFound("employee not found"));
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        return employeeDTO;
    }
    @Override
    public String removeEmployee(long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFound("Employee not existing"));
        employeeRepository.deleteById(id);
        return "Employee removed successfully";
    }
    @Override
    public Employee updateEmployeeDetails(Employee employee,long id) {
        Employee emp=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFound("employee not found"));
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setId(employee.getId());
        employeeRepository.save(emp);
        return emp;
    }
}
