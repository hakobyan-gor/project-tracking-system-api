package com.tracking.system.repositories.contact;

import com.tracking.system.models.entities.coontact.Contact;
import com.tracking.system.repositories.BaseRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ContactRepository extends BaseRepository<Contact> {

    @Transactional
    @Modifying
    void deleteAllByProjectId(Long projectId);

}