package com.tracking.system.models.dtos.project;

import com.tracking.system.models.dtos.contact.ContactCreatingDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public record ProjectCreatingDto(
        @NotBlank @Size(min = 2, message = "Project title must contain minimum 2 characters.") String title,
        int status,
        @NotNull List<ContactCreatingDto> projectContacts
) {
}