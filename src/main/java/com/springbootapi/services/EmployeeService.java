package com.springbootapi.services;


import com.springbootapi.model.Employee;
import com.springbootapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    //CRUD CREATE READ UPDATE DELETE

    //CREATE
    public Employee addEmployee(Employee employee){
        employee.setEmpId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(employee);
    }

    //READ
    public List<Employee> findAllEmployee(){
        return repository.findAll();
    }

    public Employee getEmployeeByEmpId(String empId){
        return repository.findById(empId).get();
    }


    //UPDATE
    public Employee updateEmployee(Employee employeeRequest){
        //get the existing employee
        // populate new value from request to existing

        Employee currentEmployee = repository.findById(employeeRequest.getEmpId()).get();
        currentEmployee.setEmpEmail(employeeRequest.getEmpEmail());
        currentEmployee.setEmpFirstName(employeeRequest.getEmpFirstName());
        currentEmployee.setEmpLastName(employeeRequest.getEmpLastName());
        currentEmployee.setEmpGender(employeeRequest.getEmpGender());
        currentEmployee.setEmpPhoneNumber(employeeRequest.getEmpPhoneNumber());
        return repository.save(currentEmployee);
    }

    public String  deleteEmployee(String employeeId){
        repository.deleteById(employeeId);
        return employeeId + "has been deleted";
    }
}
