package com.tracking.system.models.entities.user;

import com.tracking.system.models.entities.BaseEntity;
import com.tracking.system.models.entities.user.role.Role;
import lombok.*;

import javax.persistence.*;

@Table(name = "AppUser")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class AppUser extends BaseEntity {

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "BirthDate")
    private Long birthDate;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "RoleId", nullable = false)
    private Role role;

}