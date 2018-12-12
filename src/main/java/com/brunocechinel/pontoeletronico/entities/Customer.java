package com.brunocechinel.pontoeletronico.entities;

import com.brunocechinel.pontoeletronico.entities.audit.AuditEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private final List<Employee> employees;
}
