package com.tracking.system.models.entities.user.role;

import com.tracking.system.models.entities.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "Role")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Role extends BaseEntity {

    @Column(name = "RoleName")
    private String roleName;

    @Column(name = "RoleDescription")
    private String roleDescription;

}