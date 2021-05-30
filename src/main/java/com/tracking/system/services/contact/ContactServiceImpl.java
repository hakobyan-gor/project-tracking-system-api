package com.tracking.system.services.contact;

import com.tracking.system.repositories.contact.ContactRepository;
import com.tracking.system.exceptions.EntityNotFoundException;
import com.tracking.system.models.entities.coontact.Contact;
import com.tracking.system.services.AbstractService;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl extends AbstractService<Contact, ContactRepository> implements ContactService {

    @Lazy
    private final ContactRepository mRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        super(contactRepository);
        this.mRepository = contactRepository;
    }

    @Override
    public Contact getById(Long id) throws EntityNotFoundException {
        Optional<Contact> optionalContact = mRepository.findById(id);
        return optionalContact.orElseThrow(
                () -> new EntityNotFoundException(Contact.class, "Id", String.valueOf(id))
        );
    }

    @Override
    public Boolean deleteContact(Long id) throws EntityNotFoundException {
        Contact contact = getById(id);
        contact.setDeleted(true);
        return true;
    }

}