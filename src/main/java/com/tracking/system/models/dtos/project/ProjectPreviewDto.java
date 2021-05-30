package com.tracking.system.models.dtos.project;

import java.util.List;

public record ProjectPreviewDto(
        Long projectId,
        String title,
        int status,
        List<ProjectContactsPreviewDto> projectContacts
) {

    public record ProjectContactsPreviewDto(
            String phoneNumber,
            String fullName,
            String email,
            Long id
    ) {
    }

}
