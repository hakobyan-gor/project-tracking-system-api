package com.tracking.system.models.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Admin extends AppUser {
}