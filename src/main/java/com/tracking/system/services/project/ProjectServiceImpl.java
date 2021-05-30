package com.tracking.system.services.project;

import com.tracking.system.repositories.project.ProjectRepository;
import com.tracking.system.exceptions.EntityNotFoundException;
import com.tracking.system.models.entities.project.Project;
import com.tracking.system.services.AbstractService;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl extends AbstractService<Project, ProjectRepository> implements ProjectService {

    @Lazy
    private final ProjectRepository mRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        super(projectRepository);
        this.mRepository = projectRepository;
    }

    @Override
    public Project getById(Long projectId) throws EntityNotFoundException {
        Optional<Project> optionalProject = mRepository.findByIdAndDeletedFalse(projectId);
        return optionalProject.orElseThrow(
                () -> new EntityNotFoundException(Project.class, "Id", String.valueOf(projectId))
        );
    }

    @Override
    public Boolean deleteProject(Long id) throws EntityNotFoundException {
        Project project = getById(id);
        project.setDeleted(true);
        return true;
    }

}