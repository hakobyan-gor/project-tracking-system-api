package com.tracking.system.models.dtos.contact;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public record ContactCreatingDto(
        @NotBlank @Size(min = 2, message = "Contact title must contain minimum 2 characters.") String fullName,
        @NotBlank @Email String email,
        String phoneNumber
) {
}