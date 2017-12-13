package com.fomichov.gmail.m.hibernate.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
    void save(T t);
    void update(T t);
    T getById(ID id);
    void remove(ID id);
    List<T> getAll();
}
