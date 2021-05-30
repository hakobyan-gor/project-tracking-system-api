package com.tracking.system.repositories.user;

import com.tracking.system.models.entities.user.AppUser;
import com.tracking.system.repositories.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<AppUser> {

    @Query("SELECT u FROM AppUser u WHERE u.deleted = FALSE AND (u.email = :username OR u.phoneNumber = :username OR u.username = :username)")
    Optional<AppUser> findByUsername(@Param("username") String username);

}