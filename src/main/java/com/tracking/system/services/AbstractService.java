package com.tracking.system.services;

import com.tracking.system.repositories.BaseRepository;
import com.tracking.system.models.entities.BaseEntity;

public abstract class AbstractService<E extends BaseEntity, R extends BaseRepository<E>> implements BaseService<E> {

    private final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public Long save(E entity) {
        entity.setDeleted(false);
        return repository.save(entity).getId();
    }

    @Override
    public Iterable<E> saveAll(Iterable<E> iterable) {
        return repository.saveAll(iterable);
    }

    @Override
    public Long countAllByDeletedFalse() {
        return repository.countAllByDeletedFalse();
    }

}