package com.youcode.repositories;


import java.util.List;
import java.util.Optional;



public interface BaseDAOIntf<E,ID> {
    E save(E entity);
    void update(E entity);
    List<E> findAll();
    Optional<E> findById(ID id);
    void delete(E entity);
    void deleteById(ID id);
}
