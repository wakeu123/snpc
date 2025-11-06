package com.gaia.snpc.domains.entities;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {


    @Id
    @Basic(optional = false)
    private String id;

    @CreatedDate
    @Basic(optional = false)
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public BaseEntity() {
        setId(UUID.randomUUID().toString());
    }

    public BaseEntity(String id) {
        setId(id);
        setId(UUID.randomUUID().toString());
    }
}
