package com.emp.employeeone.exception;

public class EmployeeNotFound extends RuntimeException{
   public EmployeeNotFound(String message){
        super(message);
    }
}
