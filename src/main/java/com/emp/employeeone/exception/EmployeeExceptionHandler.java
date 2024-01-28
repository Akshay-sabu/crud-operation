package com.emp.employeeone.exception;

import com.emp.employeeone.exception.EmployeeNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFound employeeNotFound){
        return new ResponseEntity<String>(employeeNotFound.getMessage(), HttpStatus.NOT_FOUND);
    }
}
