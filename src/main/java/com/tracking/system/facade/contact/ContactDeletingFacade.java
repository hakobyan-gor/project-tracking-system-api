package com.tracking.system.facade.contact;

import com.tracking.system.services.contact.ContactService;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ContactDeletingFacade {

    @Lazy
    private final ContactService mService;

    public ContactDeletingFacade(
            ContactService contactService
    ) {
        this.mService = contactService;
    }

    public Boolean deleteContact(Long contactId) throws Exception {
        return mService.deleteContact(contactId);
    }

}