package com.tracking.system.facade.project;

import com.tracking.system.models.dtos.project.ProjectCreatingDto;
import com.tracking.system.repositories.contact.ContactRepository;
import com.tracking.system.repositories.project.ProjectRepository;
import com.tracking.system.models.entities.project.Project;
import com.tracking.system.convert.ProjectConverter;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProjectCreatingFacade {

    @Lazy
    private final ProjectRepository mRepository;
    @Lazy
    private final ContactRepository mContactRepository;

    public ProjectCreatingFacade(
            ProjectRepository projectRepository,
            ContactRepository contactRepository
    ) {
        this.mRepository = projectRepository;
        this.mContactRepository = contactRepository;
    }

    public Long createProject(ProjectCreatingDto projectCreatingDto) throws Exception {
        Project project = ProjectConverter.convertToEntity(projectCreatingDto);
        mRepository.save(project);
        project.getContactList().forEach(contact -> contact.setProject(project));
        mContactRepository.saveAll(project.getContactList());
        return project.getId();
    }

}