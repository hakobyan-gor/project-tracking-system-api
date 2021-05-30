package com.tracking.system.convert;

import com.tracking.system.models.dtos.project.ProjectListPreviewDto;
import com.tracking.system.models.dtos.project.ProjectCreatingDto;
import com.tracking.system.models.dtos.project.ProjectPreviewDto;
import com.tracking.system.models.entities.project.Project;
import com.tracking.system.exceptions.MessageException;
import com.tracking.system.enums.ProjectStatusEnum;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

public class ProjectConverter {

    public static Project convertToEntity(ProjectCreatingDto projectCreatingDto) throws MessageException {
        return Project
                .builder()
                .projectStatus(ProjectStatusEnum.valueOf(projectCreatingDto.status()).orElseThrow(
                        () -> new MessageException("Incorrect project status value.")
                ))
                .title(projectCreatingDto.title())
                .contactList(ContactConverter.convertToEntityList(projectCreatingDto.projectContacts()))
                .build();
    }

    public static ProjectPreviewDto convertToPreviewDto(Project project) {
        return new ProjectPreviewDto(
                project.getId(),
                project.getTitle(),
                project.getProjectStatus().getValue(),
                ContactConverter.convertToPreviewDtoList(project.getContactList().stream().filter(
                        contact -> contact.getDeleted().equals(false)).collect(Collectors.toList()))
        );

    }

    public static Page<ProjectListPreviewDto> convertToPreviewDtoPage(Page<Project> projectPage) {
        return projectPage.map(ProjectConverter::convertToListPreviewDto);
    }

    private static ProjectListPreviewDto convertToListPreviewDto(Project project) {
        return new ProjectListPreviewDto(
                project.getTitle(),
                project.getId()
        );
    }
}
