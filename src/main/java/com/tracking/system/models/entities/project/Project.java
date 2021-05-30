package com.tracking.system.models.entities.project;

import com.tracking.system.models.entities.coontact.Contact;
import com.tracking.system.models.entities.BaseEntity;
import com.tracking.system.enums.ProjectStatusEnum;

import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

import lombok.*;

@Table(name = "Project")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class Project extends BaseEntity {

    @Column(name = "Title")
    private String title;

    @Column(name = "ProjectStatus")
    private ProjectStatusEnum projectStatus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Fetch(FetchMode.SUBSELECT)
    private List<Contact> contactList;

}