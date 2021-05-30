package com.tracking.system.facade.project;

import com.tracking.system.exceptions.EntityNotFoundException;
import com.tracking.system.services.project.ProjectService;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProjectDeletingFacade {

    @Lazy
    private final ProjectService mService;

    public ProjectDeletingFacade(
            ProjectService projectService
    ) {
        this.mService = projectService;
    }

    public Boolean deleteProject(Long id) throws EntityNotFoundException {
        return mService.deleteProject(id);
    }

}