package com.brunocechinel.pontoeletronico.repositories;

import com.brunocechinel.pontoeletronico.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
