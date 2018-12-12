package com.brunocechinel.pontoeletronico.repositories;

import com.brunocechinel.pontoeletronico.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
