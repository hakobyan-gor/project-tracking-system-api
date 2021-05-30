package com.tracking.system.facade.project;

import com.tracking.system.models.dtos.project.ProjectUpdatingDto;
import com.tracking.system.repositories.contact.ContactRepository;
import com.tracking.system.services.project.ProjectService;
import com.tracking.system.models.entities.project.Project;
import com.tracking.system.convert.ContactConverter;
import com.tracking.system.enums.ProjectStatusEnum;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProjectUpdatingFacade {

    @Lazy
    private final ContactRepository contactRepository;
    @Lazy
    private final ProjectService mService;

    public ProjectUpdatingFacade(
            ContactRepository contactRepository,
            ProjectService projectService
    ) {
        this.contactRepository = contactRepository;
        this.mService = projectService;
    }

    public Boolean updateProject(Long projectId, ProjectUpdatingDto projectUpdatingDto) throws Exception {
        Project project = mService.getById(projectId);
        project.setProjectStatus(ProjectStatusEnum.valueOf(projectUpdatingDto.status()).orElseThrow());
        project.setTitle(projectUpdatingDto.title());

        contactRepository.deleteAllByProjectId(projectId);

        project.setContactList(ContactConverter.convertToEntityList(projectUpdatingDto.projectContacts()));
        project.getContactList().forEach(contact -> contact.setProject(project));

        contactRepository.saveAll(project.getContactList());

        return true;
    }

}