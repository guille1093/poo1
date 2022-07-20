package com.fuerza.servicios;

import java.util.List;

/**
 * @author Quintana Guillermo
 * @since 05-04-2022
 */

public interface CrudService<T extends Object>
{

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(Long id);

    void deleteInBatch(List<T> entities);

    T findById(Long id);

    T findById(String id);

    List<T> findAll();
}
