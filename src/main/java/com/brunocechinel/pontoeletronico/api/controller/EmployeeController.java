package com.brunocechinel.pontoeletronico.api.controller;

import com.brunocechinel.pontoeletronico.entities.Employee;
import com.brunocechinel.pontoeletronico.entities.People;
import com.brunocechinel.pontoeletronico.repositories.EmployeeRepository;
import com.brunocechinel.pontoeletronico.repositories.PeopleRepository;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    
    private final PeopleRepository peopleRepository;
    private final EmployeeRepository employeeRepository;
    
    
    public EmployeeController(PeopleRepository peopleRepository, EmployeeRepository employeeRepository) {
        this.peopleRepository = peopleRepository;
        this.employeeRepository = employeeRepository;
    }
    
    @GetMapping()
    public ResponseEntity<?> getEmployee() {
        
        People people = People.builder().email("teste@teste.com").name("Teste").build();
        
        
        Employee employee = Employee.builder().people(people).admissionDate(LocalDateTime.now()).build();
        return ResponseEntity.ok(employeeRepository.save(employee));
    }
    
}