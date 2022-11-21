package com.springbootapi.controllers;

import com.springbootapi.model.Employee;
import com.springbootapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }
    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return service.findAllEmployee();

    }
    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable String empId){
        return service.getEmployeeByEmpId(empId);

    }

    @PutMapping
    public Employee modifyEmployee(@RequestBody Employee employee){
        return service.updateEmployee(employee);
    }

    @DeleteMapping("/{empId}")
    public String deleteEmployeeById(@PathVariable String empId){
        return service.deleteEmployee(empId);

    }

}
