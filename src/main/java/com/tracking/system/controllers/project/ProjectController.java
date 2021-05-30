package com.tracking.system.controllers.project;

import com.tracking.system.models.dtos.project.ProjectCreatingDto;
import com.tracking.system.models.dtos.project.ProjectUpdatingDto;
import com.tracking.system.facade.project.ProjectFacadeBuilder;
import com.tracking.system.controllers.BaseController;
import com.tracking.system.models.ResponseModel;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("project/")
@RestController
public class ProjectController extends BaseController {

    @Lazy
    private final ProjectFacadeBuilder mFacadeBuilder;

    public ProjectController(ProjectFacadeBuilder projectFacadeBuilder) {
        this.mFacadeBuilder = projectFacadeBuilder;
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseModel<?> createProject(@Valid @RequestBody ProjectCreatingDto projectCreatingDto) {
        try {
            return createSuccessResult(mFacadeBuilder.createProject(projectCreatingDto),
                    "Project created successfully.");
        } catch (Exception e) {
            return createErrorResult(e);
        }
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("{id}")
    public ResponseModel<?> getProjectDetail(@PathVariable("id") Long projectId) {
        try {
            return createSuccessResult(mFacadeBuilder.getProjectDetail(projectId),
                    "Project retrieved successfully.");
        } catch (Exception e) {
            return createErrorResult(e);
        }
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("{page}/{size}")
    public ResponseModel<?> getAllProjects(@PathVariable int page, @PathVariable int size) {
        try {
            return createSuccessResult(mFacadeBuilder.getAllProjects(PageRequest.of(page, size)),
                    "Project retrieved successfully.");
        } catch (Exception e) {
            return createErrorResult(e);
        }
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseModel<?> updateProject(
            @PathVariable("id") Long projectId,
            @Valid @RequestBody ProjectUpdatingDto projectUpdatingDto
    ) {
        try {
            return createSuccessResult(mFacadeBuilder.updateProject(projectId, projectUpdatingDto),
                    "Project updated successfully");
        } catch (Exception e) {
            return createErrorResult(e);
        }
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseModel<?> deleteProject(@PathVariable("id") Long projectId) {
        try {
            return createSuccessResult(mFacadeBuilder.deleteProject(projectId), "Project deleted successfully.");
        } catch (Exception e) {
            return createErrorResult(e);
        }
    }

}