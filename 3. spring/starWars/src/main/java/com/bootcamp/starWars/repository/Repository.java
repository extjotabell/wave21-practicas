package com.bootcamp.starWars.repository;

import java.util.List;

public interface Repository <T> {

    public List<T> findAll();
    public List<T> findbyName(String name);
    public void add(T obj);
    public void delete(T obj);
}
