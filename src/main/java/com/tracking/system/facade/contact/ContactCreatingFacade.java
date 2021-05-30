package com.tracking.system.facade.contact;

import com.tracking.system.repositories.contact.ContactRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ContactCreatingFacade {

    @Lazy
    private final ContactRepository mRepository;

    public ContactCreatingFacade(ContactRepository contactRepository) {
        this.mRepository = contactRepository;
    }

}