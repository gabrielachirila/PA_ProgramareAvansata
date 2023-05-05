package org.example;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    void create(T entity) throws SQLException;
    List<T> findAll();

    T findByName(String name);
    T findById(int id);

}
