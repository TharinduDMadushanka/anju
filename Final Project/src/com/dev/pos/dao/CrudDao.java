package com.dev.pos.dao;

import java.util.List;

public interface CrudDao<T, ID> {
    public boolean save(T t) throws Exception,ClassNotFoundException;

    public boolean update(T t) throws Exception,ClassNotFoundException;

    public boolean delete(ID id) throws Exception,ClassNotFoundException;

    public T find(ID id) throws Exception,ClassNotFoundException;

    public List<T> findAll() throws Exception,ClassNotFoundException;

    public List<T> search(ID id) throws Exception,ClassNotFoundException;
}
