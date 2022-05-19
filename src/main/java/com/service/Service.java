package com.service;

import com.entity.AbstractEntity;

import java.util.List;

public interface Service<T extends AbstractEntity> {
    T read(long id);
    List<T> read();
    void save(T entity);
    void delete(long id);
    void edit(T entity);
}
