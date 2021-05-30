package com.tracking.system.services.contact;

import com.tracking.system.exceptions.EntityNotFoundException;
import com.tracking.system.models.entities.coontact.Contact;
import com.tracking.system.services.BaseService;

public interface ContactService extends BaseService<Contact> {

    Contact getById(Long id) throws EntityNotFoundException;

    Boolean deleteContact(Long id) throws EntityNotFoundException;
}