package com.tracking.system.services.project;

import com.tracking.system.exceptions.EntityNotFoundException;
import com.tracking.system.models.entities.project.Project;

public interface ProjectService {

    Project getById(Long projectId) throws EntityNotFoundException;

    Boolean deleteProject(Long id) throws EntityNotFoundException;

}