package com.tracking.system.services;

import com.tracking.system.models.entities.BaseEntity;

public interface BaseService<B extends BaseEntity> {

    Long save(B entity);

    Iterable<B> saveAll(Iterable<B> iterable);

    Long countAllByDeletedFalse();

}