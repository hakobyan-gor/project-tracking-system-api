package com.tracking.system.facade.contact;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ContactFacadeBuilder {

    @Lazy
    private final ContactCreatingFacade mCreatingFacade;
    @Lazy
    private final ContactPreviewFacade mPreviewFacade;
    @Lazy
    private final ContactUpdatingFacade mUpdatingFacade;
    @Lazy
    private final ContactDeletingFacade mDeletingFacade;

    public ContactFacadeBuilder(
            ContactCreatingFacade contactCreatingFacade,
            ContactPreviewFacade contactPreviewFacade,
            ContactUpdatingFacade contactUpdatingFacade,
            ContactDeletingFacade contactDeletingFacade
    ) {
        this.mCreatingFacade = contactCreatingFacade;
        this.mPreviewFacade = contactPreviewFacade;
        this.mUpdatingFacade = contactUpdatingFacade;
        this.mDeletingFacade = contactDeletingFacade;
    }

    public Boolean deleteContact(Long contactId) throws Exception {
        return mDeletingFacade.deleteContact(contactId);
    }

}