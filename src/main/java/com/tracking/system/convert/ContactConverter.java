package com.tracking.system.convert;

import com.tracking.system.models.dtos.contact.ContactCreatingDto;
import com.tracking.system.models.dtos.project.ProjectPreviewDto;
import com.tracking.system.models.entities.coontact.Contact;

import java.util.stream.Collectors;
import java.util.List;

public class ContactConverter {

    public static List<Contact> convertToEntityList(List<ContactCreatingDto> contactCreatingDtoList) {
        return contactCreatingDtoList.stream().map(ContactConverter::convertToEntity).collect(Collectors.toList());
    }

    private static Contact convertToEntity(ContactCreatingDto contactCreatingDto) {
        return Contact
                .builder()
                .fullName(contactCreatingDto.fullName())
                .phoneNumber(contactCreatingDto.phoneNumber())
                .email(contactCreatingDto.email())
                .build();
    }

    public static List<ProjectPreviewDto.ProjectContactsPreviewDto> convertToPreviewDtoList(List<Contact> contactList) {
        return contactList.stream().map(ContactConverter::convertToDto).collect(Collectors.toList());
    }

    private static ProjectPreviewDto.ProjectContactsPreviewDto convertToDto(Contact contact) {
        return new ProjectPreviewDto.ProjectContactsPreviewDto(
                contact.getPhoneNumber(),
                contact.getFullName(),
                contact.getEmail(),
                contact.getId()
        );
    }

}