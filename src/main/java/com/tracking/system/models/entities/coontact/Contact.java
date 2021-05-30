package com.tracking.system.models.entities.coontact;

import com.tracking.system.models.entities.BaseEntity;
import com.tracking.system.models.entities.project.Project;
import lombok.*;

import javax.persistence.*;

@Table(name = "Contact")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Contact extends BaseEntity {

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProjectId", nullable = false)
    private Project project;

}