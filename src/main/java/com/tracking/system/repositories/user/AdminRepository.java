package com.tracking.system.repositories.user;

import com.tracking.system.models.entities.user.Admin;
import com.tracking.system.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends BaseRepository<Admin> {
}