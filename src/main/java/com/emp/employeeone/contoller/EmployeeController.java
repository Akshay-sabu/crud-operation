package com.emp.employeeone.contoller;

import com.emp.employeeone.dto.EmployeeDTO;
import com.emp.employeeone.model.Employee;
import com.emp.employeeone.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/save-employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }
    @GetMapping("find-employee/{id}")
    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable("id")long id){
        return new ResponseEntity<EmployeeDTO>(employeeService.findEmployee(id),HttpStatus.OK);
    }
    @GetMapping("/list-all-employees")
    public ResponseEntity<List<EmployeeDTO>>getAllEmployee(){
        return new ResponseEntity<List<EmployeeDTO>>(employeeService.getAllEmployee(),HttpStatus.OK);
    }
    @DeleteMapping("/remove-employee/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable("id") long id){
        return new ResponseEntity<String>(employeeService.removeEmployee(id),HttpStatus.OK);
    }
    @PutMapping("/update-employee/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id")long id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployeeDetails(employee,id),HttpStatus.OK);
    }

}
