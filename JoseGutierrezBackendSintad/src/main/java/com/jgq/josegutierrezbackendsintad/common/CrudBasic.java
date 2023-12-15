package com.jgq.josegutierrezbackendsintad.common;

import java.util.List;

public interface CrudBasic<T> {

    T save(T object);
    List<T> getAll();

    boolean delete(Object id);

    T getById(Object id);

    T update(T object);

    boolean changeState(Object id,boolean estado);

}
