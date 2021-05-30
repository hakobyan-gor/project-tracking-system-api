package com.tracking.system.controllers.contact;

import com.tracking.system.facade.contact.ContactFacadeBuilder;
import com.tracking.system.controllers.BaseController;
import com.tracking.system.models.ResponseModel;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("contact/")
@RestController
public class ContactController extends BaseController {

    @Lazy
    private final ContactFacadeBuilder mFacadeBuilder;

    public ContactController(ContactFacadeBuilder contactFacadeBuilder) {
        this.mFacadeBuilder = contactFacadeBuilder;
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("deleteContact/{id}")
    public ResponseModel<?> deleteContact(@PathVariable("id") Long contactId) {
        try {
            return createSuccessResult(mFacadeBuilder.deleteContact(contactId), "Contact deleted successfully");
        } catch (Exception e) {
            return createErrorResult(e);
        }
    }

}