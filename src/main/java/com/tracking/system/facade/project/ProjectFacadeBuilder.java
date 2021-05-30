package com.tracking.system.facade.project;

import com.tracking.system.models.dtos.project.ProjectListPreviewDto;
import com.tracking.system.models.dtos.project.ProjectCreatingDto;
import com.tracking.system.models.dtos.project.ProjectUpdatingDto;
import com.tracking.system.models.dtos.project.ProjectPreviewDto;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProjectFacadeBuilder {

    @Lazy
    private final ProjectCreatingFacade mCreatingFacade;
    @Lazy
    private final ProjectPreviewFacade mPreviewFacade;
    @Lazy
    private final ProjectUpdatingFacade mUpdatingFacade;
    @Lazy
    private final ProjectDeletingFacade mDeletingFacade;

    public ProjectFacadeBuilder(
            ProjectCreatingFacade projectCreatingFacade,
            ProjectPreviewFacade projectPreviewFacade,
            ProjectUpdatingFacade projectUpdatingFacade,
            ProjectDeletingFacade projectDeletingFacade
    ) {
        this.mCreatingFacade = projectCreatingFacade;
        this.mPreviewFacade = projectPreviewFacade;
        this.mUpdatingFacade = projectUpdatingFacade;
        this.mDeletingFacade = projectDeletingFacade;
    }

    public Long createProject(ProjectCreatingDto projectCreatingDto) throws Exception {
        return mCreatingFacade.createProject(projectCreatingDto);
    }

    public ProjectPreviewDto getProjectDetail(Long id) throws Exception {
        return mPreviewFacade.getProjectDetail(id);
    }

    public Page<ProjectListPreviewDto> getAllProjects(Pageable pageable) {
        return mPreviewFacade.getAllProjects(pageable);
    }

    public Boolean updateProject(Long projectId, ProjectUpdatingDto projectUpdatingDto) throws Exception {
        return mUpdatingFacade.updateProject(projectId, projectUpdatingDto);
    }

    public Boolean deleteProject(Long projectId) throws Exception {
        return mDeletingFacade.deleteProject(projectId);
    }

}