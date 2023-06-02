package com.bootcamp.calorias.repository;

import java.util.List;

public interface Repository <T> {

    public List<T> findAll();
    public T findbyName(String name);
    public void add(T obj);
    public void delete(T obj);
}
