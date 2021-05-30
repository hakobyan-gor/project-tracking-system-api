package com.tracking.system.facade.project;

import com.tracking.system.models.dtos.project.ProjectListPreviewDto;
import com.tracking.system.repositories.project.ProjectRepository;
import com.tracking.system.models.dtos.project.ProjectPreviewDto;
import com.tracking.system.services.project.ProjectService;
import com.tracking.system.models.entities.project.Project;
import com.tracking.system.convert.ProjectConverter;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProjectPreviewFacade {

    @Lazy
    private final ProjectRepository mRepository;
    @Lazy
    private final ProjectService mService;

    public ProjectPreviewFacade(
            ProjectRepository projectRepository,
            ProjectService projectService
    ) {
        this.mRepository = projectRepository;
        this.mService = projectService;
    }

    public ProjectPreviewDto getProjectDetail(Long id) throws Exception {
        Project project = mService.getById(id);
        return ProjectConverter.convertToPreviewDto(project);
    }

    public Page<ProjectListPreviewDto> getAllProjects(Pageable pageable) {
        Page<Project> projectPage = mRepository.findAllByDeletedFalse(pageable);
        return ProjectConverter.convertToPreviewDtoPage(projectPage);
    }

}