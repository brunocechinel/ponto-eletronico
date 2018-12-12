package com.brunocechinel.pontoeletronico.entities.audit;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(insertable = false, updatable = true)
    private LocalDateTime updateDate;
    
    @Column(insertable = true, updatable = false)
    private LocalDateTime createDate;
    
    @PrePersist
    void prePersist() {
        this.setCreateDate(LocalDateTime.now());
    }
    
    @PreUpdate
    void preUpdate() {
        this.setUpdateDate(LocalDateTime.now());
    }
}