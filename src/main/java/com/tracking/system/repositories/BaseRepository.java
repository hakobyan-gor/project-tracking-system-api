package com.tracking.system.repositories;

import com.tracking.system.models.entities.BaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<B extends BaseEntity> extends JpaRepository<B, Long> {

    Page<B> findAllByDeletedFalse(Pageable pageable);

    Optional<B> findByIdAndDeletedFalse(Long id);

    long countAllByDeletedFalse();

}