package com.brunocechinel.pontoeletronico.repositories;

import com.brunocechinel.pontoeletronico.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Long> {
    
}
