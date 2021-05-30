package com.tracking.system.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @Id
    private Long id;

    @Column(name = "CreatedDate")
    @CreatedDate
    private Long createdDate;

    @Column(name = "LastModifiedDate")
    @LastModifiedDate
    private Long lastModifiedDate;

    @Column(name = "CreatedBy")
    @CreatedBy
    private String createdBy;

    @Column(name = "LastModifiedBy")
    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name = "Deleted", columnDefinition = "bit DEFAULT 0", nullable = false)
    private Boolean deleted = false;

}